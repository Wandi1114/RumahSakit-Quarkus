package controllers;


import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.jwt.JsonWebToken;
import services.PerawatServices;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/v1/perawats")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"admin","superadmin"})
public class PerawatController {
    @Inject
    PerawatServices perawatServices;

    @Inject
    JsonWebToken jwt;

    @GET
    public Response getAll(@QueryParam("size")String size,
                           @QueryParam("page") String page,
                           @QueryParam("nama") String nama,
                           @QueryParam("email") String email,
                           @QueryParam("phone_number") String phone_number){
        int Rsize = size == null ? 5 : Integer.parseInt(size);
        int Rpage = page == null ? 0 : Integer.parseInt(page);
        return perawatServices.getAll(Rsize,Rpage,nama,email,phone_number);
    }

    @POST
    public Response add(JsonObject request){
        return perawatServices.add(request);
    }

    @POST
    @Path("/20perawat")
    public Response add20(){
        return perawatServices.add20();
    }

    @PUT
    @Path("/{id}")
    public Response updategaji(@PathParam("id") Long id, JsonObject request){
        return perawatServices.updateGaji(id, request);
    }

}
