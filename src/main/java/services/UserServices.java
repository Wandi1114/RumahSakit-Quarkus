package services;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.User;
import models.UserPermissions;
import models.Users;
import utils.ResponseUtils;
import utils.TokenUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserServices {

    @Inject
    EntityManager em;


    public Response getAll(){
        List<Users> result = Users.findAll().list();

        return ResponseUtils.ok(result);
    }
    @Transactional
    public Response add(JsonObject data){
        Users user = new Users();
        String name = data.getString("nama");
        String username = data.getString("username");
        String password = data.getString("password");
        String type = data.getString("user_type")==null ? "admin" : data.getString("user_type");
        if(name == null || username == null || password==null){
            return ResponseUtils.badRequest("Data wajib diisi");
        }

//      not nullable data
        user.setName(name);
        user.setUsername(username);
        user.setPassword(BcryptUtil.bcryptHash(data.getString("password")));

//        nullable data
        user.persist();

        UserPermissions up = new UserPermissions();
        up.setName(type);
        up.setUser(user);
        up.persist();

        return ResponseUtils.ok("Berhasil Register", user);
    }

    public Response login(JsonObject request){
        String username = request.getString("username");
        String password = request.getString("password");

        Users user = Users.find("username = ?1 ", username).singleResult();

        if(user == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if(BcryptUtil.matches(password,user.getPassword())){
            String token = TokenUtil.generate(user);
            System.out.println(token);
            return ResponseUtils.ok(token, user);
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
