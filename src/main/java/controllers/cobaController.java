package controllers;

import io.vertx.core.json.JsonObject;
import models.Coba;
import services.CobaServices;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/v1/coba")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class cobaController {
    @Inject
    CobaServices cobaServices;

    @Inject
    EntityManager em;

    @POST
    public Response add(){
        return cobaServices.add();
    }

}
