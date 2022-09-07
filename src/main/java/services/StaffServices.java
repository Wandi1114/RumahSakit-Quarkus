package services;


import io.quarkus.panache.common.Page;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import models.Dokters;
import models.Staffs;
import utils.ResponseUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import Enum.Posisi;

@ApplicationScoped
public class StaffServices {
    @Inject
    EntityManager em;
    private static List<String> posisiList = new ArrayList<String>(
            List.of(
                    Posisi.Engineer.toString(),
                    Posisi.Security.toString(),
                    Posisi.Janitor.toString(),
                    Posisi.Receipt.toString()
            )
    );

    public Response getAll(int size, int page,String nama,String email,String phone_number,String posisi){

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
        if (posisi != null && !posisi.isBlank()){
            sb.append(" and posisi='"+posisi+"'");
        }
        List<Staffs> result = Staffs
                .find(sb.toString())
                .page(Page.of(page,size))
                .list();
        int totalP = Staffs
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
        String email = request.getString("email");
        String phone_number = request.getString("phone_number");
        String posisi = request.getString("posisi");

        if(!posisiList.contains(posisi)){
            return ResponseUtils.badRequest("Posisi tidak tersedia, cek kategori");
        }

        Staffs staff = new Staffs();
        staff.setNama_lengkap(name);
        staff.setGaji(gaji);
        staff.setEmail(email);
        staff.setPhone_number(phone_number);
        staff.setPosisi(posisi);

        staff.persist();

        return ResponseUtils.ok(staff);
    }
    @Transactional
    public Response add20() {
        List<String> posisiList = new ArrayList<String>();
        posisiList.add(Posisi.Engineer.toString());
        posisiList.add(Posisi.Security.toString());
        posisiList.add(Posisi.Janitor.toString());
        posisiList.add(Posisi.Receipt.toString());
        for(int i=0; i<=20; i++){
            String name = "staff"+i;
            Long gaji =  2000000L;
            String email = "staff"+i+"@gadungan.com";
            String phone_number = "08123123"+i;
            int random = (i+4)%4;
            Staffs staff = new Staffs();
            staff.setNama_lengkap(name);
            staff.setGaji(gaji);
            staff.setEmail(email);
            staff.setPosisi(posisiList.get(random));
            staff.setPhone_number(phone_number);
            staff.persist();
        }

        return ResponseUtils.ok("Berhasil menabah 20 staff");
    }

    public Response posisi(){
        return ResponseUtils.ok(posisiList);
    }

    @Transactional
    public Response delete(Long id){
        Staffs staff = Staffs.findById(id);
        if(staff == null) {
            return ResponseUtils.badRequest("id tidak ditemukan.");
        }
        staff.delete();
        List<Staffs> data = Staffs.findAll().list();
        return ResponseUtils.ok("Berhasil dihapus", data);
    }

    @Transactional
    public Response updateGaji(Long id, JsonObject request){
        Staffs staff = Staffs.findById(id);
        if(staff == null) {
            return ResponseUtils.badRequest("id tidak ditemukan.");
        }
        staff.setGaji(request.getLong("gaji"));
        staff.persist();
        return ResponseUtils.ok("Berhasil dihapus", staff);
    }

}
