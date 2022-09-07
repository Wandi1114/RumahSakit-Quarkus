package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ruang_inap")
public class RuangInaps extends auditModels implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="ruang_inap_seq", sequenceName = "ruang_inap_sequence", allocationSize = 1)
    @GeneratedValue(generator = "ruang_inap_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "prefix_ruangan", nullable = false,columnDefinition = "varchar(255)")
    private String prefix_ruangan;

    @Column(name = "nomor_ruangan", nullable = false,columnDefinition = "varchar(255)")
    private String nomor_ruangan;

    @Column(name = "gedung_id",columnDefinition = "varchar(255)")
    private String gedung_id;

    @Column(name = "kategori_ruangan", nullable = false,columnDefinition = "varchar(255)")
    private String kategori_ruangan;

    @Column(name = "is_kosong", columnDefinition = "boolean default true")
    private Boolean is_kosong;

    public Long getId() {
        return id;
    }

    public String getPrefix_ruangan() {
        return prefix_ruangan;
    }

    public void setPrefix_ruangan(String prefix_ruangan) {
        this.prefix_ruangan = prefix_ruangan;
    }

    public String getNomor_ruangan() {
        return nomor_ruangan;
    }

    public void setNomor_ruangan(String nomor_ruangan) {
        this.nomor_ruangan = nomor_ruangan;
    }

    public String getGedung_id() {
        return gedung_id;
    }

    public void setGedung_id(String gedung_id) {
        this.gedung_id = gedung_id;
    }

    public String getKategori_ruangan() {
        return kategori_ruangan;
    }

    public void setKategori_ruangan(String kategori_ruangan) {
        this.kategori_ruangan = kategori_ruangan;
    }

    public Boolean getIs_kosong() {
        return is_kosong;
    }

    public void setIs_kosong(Boolean is_kosong) {
        this.is_kosong = is_kosong;
    }
}
