package controllers;

import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.jwt.JsonWebToken;
import services.PasienServices;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/v1/pasiens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"admin","superadmin"})
public class PasienController {
    @Inject
    JsonWebToken jwt;

    @Inject
    PasienServices pasienServices;

    @GET
    public Response getAll(@QueryParam("size")String size,
                           @QueryParam("page") String page,
                           @QueryParam("email") String email,
                           @QueryParam("nama") String nama,
                           @QueryParam("phone_number") String phone_number){
        int Rsize = size == null ? 5 : Integer.parseInt(size);
        int Rpage = page == null ? 0 : Integer.parseInt(page);
        return pasienServices.getAll(Rsize,Rpage,email,nama,phone_number);
    }

    @POST
    public Response add(JsonObject request){
        return pasienServices.add(request);
    }

    @PUT
    @Path("/{id}")
    public  Response update(@PathParam("id") Long id,JsonObject request){
        return pasienServices.update(id, request);
    }

    @DELETE
    @Path("/{id}")
    public  Response delete(@PathParam("id") Long id){
        return pasienServices.delete(id);
    }

}
