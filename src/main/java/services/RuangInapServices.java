package services;

import io.quarkus.panache.common.Page;
import io.vertx.core.json.JsonObject;
import models.RuangInaps;
import org.eclipse.microprofile.jwt.JsonWebToken;
import utils.ResponseUtils;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import Enum.RuangInapKategori;

@ApplicationScoped
public class RuangInapServices {

    @Inject
    EntityManager em;

    private static List<String> kategoriList = new ArrayList<String>(
            List.of(
                    RuangInapKategori.VIP.toString(),
                    RuangInapKategori.VVIP.toString()
            )
    );

    public Response getAll(int size, int page,String kategori,String nomor,String prefix, Boolean is_kosong){

        StringBuilder sb = new StringBuilder();
        sb.append("id is not null");
        if (nomor != null && !nomor.isBlank()){
            sb.append(" and nomor_ruangan='"+nomor+"'");
        }
        if (kategori != null && !kategori.isBlank()){
            sb.append(" and kategori_ruangan='"+kategori+"'");
        }
        if (prefix != null && !prefix.isBlank()){
            sb.append(" and prefix_ruangan='"+prefix+"'");
        }
//        if (is_kosong != null){
//            sb.append(" and is_kosong="+is_kosong+"");
//        }
        List<RuangInaps> result = RuangInaps
                .find(sb.toString())
                .page(Page.of(page,size))
                .list();
        int totalP = RuangInaps
                .find(sb.toString())
                .page(Page.of(page,size))
                .pageCount();
        int curpage = page+1;
        return ResponseUtils.ok(result);
    }

    @Transactional
    public Response add(JsonObject request) {

        String prefix_ruangan = request.getString("prefix_ruangan");
        String nomor_ruangan = request.getString("nomor_ruangan");
        String kategori = request.getString("kategori_ruangan");

        RuangInaps ruangInaps = new RuangInaps();
        if(prefix_ruangan!=null) {
            ruangInaps.setPrefix_ruangan(prefix_ruangan);
        }
        if(nomor_ruangan!=null) {
            ruangInaps.setNomor_ruangan(nomor_ruangan);
        }
        if(kategori!=null) {
            ruangInaps.setKategori_ruangan(kategori);
        }
        ruangInaps.persist();


        return ResponseUtils.ok(ruangInaps);
    }

    @Transactional
    public Response update(Long id, JsonObject request){

        String prefix_ruangan = request.getString("prefix_ruangan");
        String nomor_ruangan = request.getString("nomor_ruangan");
        String kategori = request.getString("kategori_ruangan");
        Boolean is_kosong = request.getBoolean("is_kosong")!=null ? request.getBoolean("is_kosong") : false;

        RuangInaps ruangInaps = RuangInaps.findById(id);
        if(prefix_ruangan!=null) {
            ruangInaps.setPrefix_ruangan(prefix_ruangan);
        }
        if(nomor_ruangan!=null) {
            ruangInaps.setNomor_ruangan(nomor_ruangan);
        }
        if(kategori!=null) {
            ruangInaps.setKategori_ruangan(kategori);
        }
        ruangInaps.setIs_kosong(is_kosong);
        ruangInaps.persist();

        return ResponseUtils.ok("Berhasil update", ruangInaps);
    }

    @Transactional
    public Response delete(Long id){
        RuangInaps ruangInap = RuangInaps.findById(id);
        if(ruangInap == null) {
            return ResponseUtils.badRequest("id tidak ditemukan.");
        }
        ruangInap.delete();
        List<RuangInaps> data = RuangInaps.findAll().list();
        return ResponseUtils.ok("Data berhasil dihapus", data);
    }

    public Response kategori(){
        return ResponseUtils.ok(kategoriList);
    }

}
