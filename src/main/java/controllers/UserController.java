package controllers;

import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.jwt.JsonWebToken;
import services.UserServices;
import utils.ResponseUtils;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    UserServices userServices;

    @Inject
    JsonWebToken jwt;

    @POST
    @RolesAllowed({"superadmin"})
    public Response add(JsonObject data){
        return userServices.add(data);
    }

    @GET
    public Response getAll(){
        return userServices.getAll();
    }

    @POST
    @Path("/login")
    public Response login(JsonObject data){
        return userServices.login(data);
    }

}
