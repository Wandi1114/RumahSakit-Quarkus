package services;

import io.quarkus.panache.common.Page;
import io.vertx.core.json.JsonObject;
import models.Obats;
import models.Pasiens;
import utils.ResponseUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class PasienServices {

    @Inject
    EntityManager em;

    public Response getAll(int size, int page, String email, String nama, String phone_number){

        StringBuilder sb = new StringBuilder();
        sb.append("id is not null");
        if (nama != null && !nama.isBlank()){
            sb.append(" and nama_obat='"+nama+"'");
        }
        if (email != null && !email.isBlank()){
            sb.append(" and email='"+email+"'");
        }

        if (phone_number != null && !phone_number.isBlank()){
            sb.append(" and phone_number='"+phone_number+"'");
        }

        List<Pasiens> result = Pasiens
                .find(sb.toString())
                .page(Page.of(page,size))
                .list();

        int totalP = Pasiens
                .find(sb.toString())
                .page(Page.of(page,size))
                .pageCount();

        int curpage = page+1;

        return ResponseUtils.ok(result);
    }

    @Transactional
    public Response add(JsonObject request) {

        String name = request.getString("nama");
        String email = request.getString("email");
        String phone_number = request.getString("phone_number");
        String gender = request.getString("gender");
        String status = request.getString("status");
        String address = request.getString("address");
        Boolean is_cover_bpjs = request.getBoolean("is_cover_bpjs");

        Pasiens pasien = new Pasiens();

        pasien.setNama_lengkap(name);
        pasien.setGender(gender);
        pasien.setAddress(address);
        pasien.setEmail(email);
        pasien.setStatus(status);
        pasien.setPhone_number(phone_number);
        pasien.setIs_cover_bpjs(is_cover_bpjs);
        pasien.persist();

        return ResponseUtils.ok(pasien);
    }

    @Transactional
    public Response update(Long id, JsonObject request){

        String name = request.getString("nama");
        String email = request.getString("email");
        String phone_number = request.getString("phone_number");
        String gender = request.getString("gender");
        String status = request.getString("status");
        String address = request.getString("address");
        Boolean is_cover_bpjs = request.getBoolean("is_cover_bpjs");

        Pasiens pasien = Pasiens.findById(id);
        if(name!=null) {
            pasien.setNama_lengkap(name);
        }
        if(email!=null) {
            pasien.setEmail(email);
        }
        if(phone_number!=null) {
            pasien.setPhone_number(phone_number);
        }
        if(gender!=null) {
            pasien.setGender(gender);
        }
        if(status!=null) {
            pasien.setStatus(status);
        }
        if(address!=null) {
            pasien.setAddress(address);
        }
        pasien.persist();

        return ResponseUtils.ok("Berhasil update", pasien);
    }

    @Transactional
    public Response delete(Long id){
        Pasiens pasien = Pasiens.findById(id);
        if(pasien == null) {
            return ResponseUtils.badRequest("id tidak ditemukan.");
        }
        pasien.delete();
        List<Pasiens> data = Pasiens.findAll().list();
        return ResponseUtils.ok("Data berhasil dihapus", data);
    }
}
