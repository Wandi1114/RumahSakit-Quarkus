package utils;

import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseUtils {

    public static Response ok(Object data){
        JsonObject response = new JsonObject();
        response.put("success", true);
        response.put("data", data);
        return Response
                .ok()
                .entity(response)
                .build();
    }
    public static Response ok(Object data, Integer total,Integer curpage, Integer totalPage){
        JsonObject response = new JsonObject();
        response.put("total_page", totalPage);
        response.put("current_page", curpage);
        response.put("total", total);
        response.put("data", data);
        return Response
                .ok()
                .entity(response)
                .build();
    }
    public static Response ok(String message,Object data){
        JsonObject response = new JsonObject();
        response.put("success", true);
        response.put("data", data);
        response.put("message", message);
        return Response
                .status(Response.Status.OK)
                .entity(response)
                .build();
    }

    public static Response badRequest(String message){
        JsonObject response = new JsonObject();
        response.put("success", false);
        response.put("message", message);
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(response)
                .build();
    }

    public static Response unauthorized(String message){
        JsonObject response = new JsonObject();
        response.put("success", false);
        response.put("message", message);
        return Response
                .status(Response.Status.UNAUTHORIZED)
                .entity(response)
                .build();
    }

    public static Response forbidden(String message){
        JsonObject response = new JsonObject();
        response.put("success", false);
        response.put("message", message);
        return Response
                .status(Response.Status.FORBIDDEN)
                .entity(response)
                .build();
    }
}
