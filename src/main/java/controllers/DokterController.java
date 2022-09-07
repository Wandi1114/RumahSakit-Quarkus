package controllers;

import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.jwt.JsonWebToken;
import services.DokterServices;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("api/v1/dokters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"admin","superadmin"})
public class DokterController {
    @Inject
    DokterServices dokterServices;

    @Inject
    JsonWebToken jwt;

    @GET
    public Response getAll(@QueryParam("size")String size,
                           @QueryParam("page") String page,
                           @QueryParam("spesialis") String spesialis,
                           @QueryParam("nama") String nama,
                           @QueryParam("email") String email,
                           @QueryParam("phone_number") String phone_number){
        int Rsize = size == null ? 5 : Integer.parseInt(size);
        int Rpage = page == null ? 0 : Integer.parseInt(page);
        return dokterServices.getAll(Rsize,Rpage,spesialis,nama,email,phone_number);
    }

    @POST
    public Response add(JsonObject request){
        return dokterServices.add(request);
    }

    @POST
    @Path("/20dokter")
    public Response add20(){
        return dokterServices.add20();
    }

    @PUT
    @Path("/{id}")
    public Response updategaji(@PathParam("id") Long id, JsonObject request){
        return dokterServices.updateGaji(id, request);
    }

}
