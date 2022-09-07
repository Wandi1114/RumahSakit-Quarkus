package services;

import io.quarkus.panache.common.Page;
import io.vertx.core.json.JsonObject;
import models.Perawats;
import utils.ResponseUtils;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@RolesAllowed({"admin","superadmin"})
public class PerawatServices {
    @Inject
    EntityManager em;


    public Response getAll(int size, int page,String nama,String email,String phone_number){

        StringBuilder sb = new StringBuilder();
        sb.append("id is not null");
        if (nama != null && !nama.isBlank()){
            sb.append(" and nama_lengkap='"+nama+"'");
        }
        if (email != null && !email.isBlank()){
            sb.append(" and email='"+email+"'");
        }
        if (phone_number != null && !phone_number.isBlank()){
            sb.append(" and phone_number='"+phone_number+"'");
        }
        List<Perawats> result = Perawats
                .find(sb.toString())
                .page(Page.of(page,size))
                .list();

        int totalP = Perawats
                .find(sb.toString())
                .page(Page.of(page,size))
                .pageCount();
        int curpage = page+1;

        return ResponseUtils.ok(result,size,curpage,totalP);
    }

    @Transactional
    public Response add(JsonObject request) {

        String name = request.getString("name");
        Long gaji =  request.getLong("gaji");
        String gender = request.getString("gender");
        String email = request.getString("email");
        String phone_number = request.getString("phone_number");
        Perawats perawat = new Perawats();

        perawat.setNama_lengkap(name);
        perawat.setGender(gender);
        perawat.setGaji(gaji);
        perawat.setEmail(email);
        perawat.setPhone_number(phone_number);

        perawat.persist();

        return ResponseUtils.ok(perawat);
    }
    @Transactional
    public Response add20() {
        for(int i=0; i<=20; i++){
            String name = "perawat"+i;
            Long gaji =  2000000L;
            String email = "perawat"+i+"@gadungan.com";
            String phone_number = "081231212"+i;

            Perawats perawat = new Perawats();
            perawat.setNama_lengkap(name);
            perawat.setGaji(gaji);
            perawat.setEmail(email);
            perawat.setPhone_number(phone_number);
            perawat.persist();
        }

        return ResponseUtils.ok("Berhasil menabah 20 perawat");
    }

    @Transactional
    public Response updateGaji(Long id, JsonObject request){
        Perawats perawat = Perawats.findById(id);
        if(perawat == null) {
            return ResponseUtils.badRequest("id tidak ditemukan.");
        }
        perawat.setGaji(request.getLong("gaji"));
        perawat.persist();
        return ResponseUtils.ok("Berhasil dihapus", perawat);
    }

}
