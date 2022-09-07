package services;


import io.quarkus.panache.common.Page;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import models.Obats;
import models.Staffs;
import utils.ResponseUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import Enum.ObatKategori;

@ApplicationScoped
public class ObatServices {
    @Inject
    EntityManager em;



    private static List<String> kategoriList = new ArrayList<String>(
            List.of(
                    ObatKategori.Cair.toString(),
                    ObatKategori.Syrup.toString(),
                    ObatKategori.Pil.toString(),
                    ObatKategori.Other.toString()
            )
    );
    public Response getAll(int size, int page, String kategori,String nama, String produksi, String deskripsi){

        StringBuilder sb = new StringBuilder();
        sb.append("id is not null");
        if (nama != null && !nama.isBlank()){
            sb.append(" and nama_obat='"+nama+"'");
        }
        if (kategori != null && !kategori.isBlank()){
            sb.append(" and obat_kategori='"+kategori+"'");
        }

        if (produksi != null && !produksi.isBlank()){
            sb.append(" and produksi='"+produksi+"'");
        }
        if (deskripsi != null && !deskripsi.isBlank()){
            sb.append(" and deskripsi='"+deskripsi+"'");
        }
        List<Obats> result = Obats
                .find(sb.toString())
                .page(Page.of(page,size))
                .list();
        int totalP = Obats
                .find(sb.toString())
                .page(Page.of(page,size))
                .pageCount();
        int curpage = page+1;
        return ResponseUtils.ok(result);
    }

    @Transactional
    public Response add(JsonObject request) {

        String name = request.getString("nama");
        String produksi = request.getString("produksi");
        String kategori = request.getString("kategori");
        String deksripsi = request.getString("deskripsi");

        if(!kategoriList.contains(kategori)){
            return ResponseUtils.badRequest("kategori obat tidak tersedia, cek kategori");
        }

        Obats obat = new Obats();

        obat.setNama_obat(name);
        obat.setObat_kategori(kategori);
        obat.setDeskripsi(deksripsi);
        obat.setProduksi(produksi);
        obat.persist();


        return ResponseUtils.ok(obat);
    }

    @Transactional
    public Response update(Long id, JsonObject request){

        String name = request.getString("nama");
        String produksi = request.getString("produksi");
        String kategori = request.getString("kategori");
        String deksripsi = request.getString("deksripsi");

        Obats obat = Obats.findById(id);
        if(name!=null) {
            obat.setNama_obat(name);
        }
        if(produksi!=null) {
            obat.setProduksi(produksi);
        }
        if(kategori!=null) {
            obat.setObat_kategori(kategori);
        }
        if(deksripsi!=null) {
            obat.setDeskripsi(deksripsi);
        }
        obat.persist();

        return ResponseUtils.ok("Berhasil update", obat);
    }

    @Transactional
    public Response delete(Long id){
        Obats obat = Obats.findById(id);
        if(obat == null) {
            return ResponseUtils.badRequest("id tidak ditemukan.");
        }
        obat.delete();
        List<Obats> data = Obats.findAll().list();
        return ResponseUtils.ok("Data berhasil dihapus", data);
    }

    @Transactional
    public Response add20() {
        for(int i=0; i<=20; i++){
            String name = "obat"+i;
            Long gaji =  300000+i+1L;
            String email = "obat"+i+"@gadungan.com";
            String phone_number = "08123123"+i;

            Obats obat = new Obats();
            obat.setNama_obat(name);
//            obat.setProduksi(gaji);
            obat.setDeskripsi(email);
            obat.setObat_kategori(phone_number);
            obat.persist();
        }

        return ResponseUtils.ok("Berhasil menabah 20 obat");
    }

    public Response kategori(){
        return ResponseUtils.ok(kategoriList);
    }
}
