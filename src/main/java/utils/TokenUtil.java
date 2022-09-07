package utils;

import io.smallrye.jwt.build.Jwt;
import io.vertx.ext.auth.User;
import models.UserPermissions;
import models.Users;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TokenUtil {
    public static String generate(Users user){
        List<UserPermissions> userPermissionsList = UserPermissions.find("user_id = ?1", user.getId()).list();

        Set<String> groups = new HashSet<>(userPermissionsList
                .stream()
                .map(s -> s.getName())
                .collect(Collectors.toSet()));
        return Jwt.issuer("http://kawahedukasi/issuer")
                .expiresIn(6000L)
                .upn(user.getUsername())
                .groups(groups)
                .sign();
    }
}
