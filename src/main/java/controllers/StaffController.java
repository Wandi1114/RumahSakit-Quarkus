package controllers;

import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.jwt.JsonWebToken;
import services.DokterServices;
import services.StaffServices;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/v1/staffs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"admin","superadmin"})
public class StaffController {
    @Inject
    StaffServices staffServices;

    @Inject
    JsonWebToken jwt;

    @GET
    public Response getAll(@QueryParam("size")String size,
                           @QueryParam("page") String page,
                           @QueryParam("nama") String nama,
                           @QueryParam("email") String email,
                           @QueryParam("phone_number") String phone_number,
                           @QueryParam("posisi") String posisi){
        int Rsize = size == null ? 5 : Integer.parseInt(size);
        int Rpage = page == null ? 0 : Integer.parseInt(page);
        return staffServices.getAll(Rsize,Rpage,nama,email,phone_number,posisi);
    }

    @POST
    public Response add(JsonObject request){
        return staffServices.add(request);
    }

    @POST
    @Path("/20staff")
    public Response add20(){
        return staffServices.add20();
    }

    @GET
    @Path("/posisi")
    public Response posisi(){
        return staffServices.posisi();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        return staffServices.delete(id);
    }

    @PUT
    @Path("/{id}")
    public Response updategaji(@PathParam("id") Long id, JsonObject request){
        return staffServices.updateGaji(id, request);
    }

}
