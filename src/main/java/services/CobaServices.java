package services;

import models.Coba;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;


@ApplicationScoped
public class CobaServices {
    @Inject
    EntityManager em;

    @Transactional
    public Response add(){
        Coba newCoba = new Coba();
        newCoba.setName("valid");
        newCoba.persist();

        Coba cob = Coba.find("id = 1").singleResult();

        return Response.ok(newCoba).build();
    }
}
