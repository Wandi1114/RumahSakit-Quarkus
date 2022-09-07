package services;

import io.quarkus.panache.common.Page;
import io.vertx.core.json.JsonObject;
import models.Dokters;
import utils.ResponseUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;


@ApplicationScoped
public class DokterServices {
    @Inject
    EntityManager em;

    public Response getAll(int size, int page,String spesialis,String nama,String email,String phone_number){

        StringBuilder sb = new StringBuilder();
        sb.append("id is not null");
        if (nama != null && !nama.isBlank()){
            sb.append(" and nama_lengkap='"+nama+"'");
        }
        if (spesialis != null && !spesialis.isBlank()){
            sb.append(" and spesialis='"+spesialis+"'");
        }
        if (email != null && !email.isBlank()){
            sb.append(" and email='"+email+"'");
        }
        if (phone_number != null && !phone_number.isBlank()){
            sb.append(" and phone_number='"+phone_number+"'");
        }
        List<Dokters> result = Dokters
                .find(sb.toString())
                .page(Page.of(page,size))
                .list();

        int totalP = Dokters
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
        String spesialis = request.getString("spesialis");
        String email = request.getString("email");
        String phone_number = request.getString("phone_number");
        Dokters dokter = new Dokters();

        dokter.setNama_lengkap(name);
        dokter.setGaji(gaji);
        dokter.setEmail(email);
        dokter.setPhone_number(phone_number);
        if(spesialis != null){
            dokter.setSpesialis_nama(spesialis);
            dokter.setIs_spesialis(true);
        }
        dokter.persist();


        return ResponseUtils.ok(dokter);
    }

    @Transactional
    public Response updateGaji(Long id, JsonObject request){
        Dokters dokter = Dokters.findById(id);
        if(dokter == null) {
            return ResponseUtils.badRequest("id tidak ditemukan.");
        }
        dokter.setGaji(request.getLong("gaji"));
        dokter.persist();
        return ResponseUtils.ok("Berhasil dihapus", dokter);
    }

    @Transactional
    public Response add20() {
    for(int i=0; i<=20; i++){
        String name = "dokter"+i;
        Long gaji =  300000+i+1L;
        String email = "dokter"+i+"@gadungan.com";
        String phone_number = "08123123"+i;

        Dokters dokter = new Dokters();
        dokter.setNama_lengkap(name);
        dokter.setGaji(gaji);
        dokter.setEmail(email);
        dokter.setPhone_number(phone_number);
        dokter.persist();
    }

        return ResponseUtils.ok("Berhasil menabah 20 dokter");
    }

}
