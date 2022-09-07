package controllers;


import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.jwt.JsonWebToken;
import services.ObatServices;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/v1/obats")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"admin","superadmin"})
public class ObatController {
    @Inject
    JsonWebToken jwt;

    @Inject
    ObatServices obatServices;

    @GET
    public Response getAll(@QueryParam("size")String size,
                           @QueryParam("page") String page,
                           @QueryParam("kategori") String kategori,
                           @QueryParam("nama") String nama,
                           @QueryParam("produksi") String produksi,
                           @QueryParam("deskripsi") String deskripsi){
        int Rsize = size == null ? 5 : Integer.parseInt(size);
        int Rpage = page == null ? 0 : Integer.parseInt(page);
        return obatServices.getAll(Rsize,Rpage,kategori,nama,  produksi,  deskripsi);
    }

    @POST
    public Response add(JsonObject request){
        return obatServices.add(request);
    }

    @PUT
    @Path("/{id}")
    public  Response update(@PathParam("id") Long id,JsonObject request){
        return obatServices.update(id, request);
    }

    @DELETE
    @Path("/{id}")
    public  Response delete(@PathParam("id") Long id){
        return obatServices.delete(id);
    }

    @GET
    @Path("/kategori")
    public Response kategori(){
        return obatServices.kategori();
    }

    @POST
    @Path("/50obat")
    public Response add20(){
        return obatServices.add20();
    }
}
