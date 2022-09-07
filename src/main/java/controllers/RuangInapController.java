package controllers;

import io.vertx.core.json.JsonObject;
import models.RuangInaps;
import org.eclipse.microprofile.jwt.JsonWebToken;
import services.RuangInapServices;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/v1/ruanginaps")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"admin","superadmin"})
public class RuangInapController {
    @Inject
    JsonWebToken jwt;

    @Inject
    RuangInapServices ruangInapServices;

    @GET
    public Response getAll(@QueryParam("size")String size,
                           @QueryParam("page") String page,
                           @QueryParam("kategori") String kategori,
                           @QueryParam("nomor") String nomor,
                           @QueryParam("prefix") String prefix,
                           @QueryParam("is_kosong") Boolean is_kosong){
        int Rsize = size == null ? 5 : Integer.parseInt(size);
        int Rpage = page == null ? 0 : Integer.parseInt(page);
        return ruangInapServices.getAll(Rsize,Rpage,kategori,nomor,prefix,is_kosong);
    }

    @POST
    public Response add(JsonObject request){
        return ruangInapServices.add(request);
    }

    @PUT
    @Path("/{id}")
    public  Response update(@PathParam("id") Long id,JsonObject request){
        return ruangInapServices.update(id, request);
    }

    @DELETE
    @Path("/{id}")
    public  Response delete(@PathParam("id") Long id){
        return ruangInapServices.delete(id);
    }

    @GET
    @Path("/kategori")
    public Response kategori(){
        return ruangInapServices.kategori();
    }

}
