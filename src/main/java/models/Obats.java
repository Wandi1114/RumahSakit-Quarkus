package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "obat")
public class Obats extends auditModels implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="obat_seq", sequenceName = "obat_sequence", allocationSize = 1)
    @GeneratedValue(generator = "obat_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nama_obat", columnDefinition = "varchar(255)")
    private String nama_obat;

    @Column(name = "produksi", columnDefinition = "varchar(255)")
    private String produksi;

    @Column(name = "obat_kategori", columnDefinition = "varchar(255)")
    private String obat_kategori;

    @Column(name = "deskripsi", columnDefinition = "varchar(255)")
    private String deskripsi;

    public Long getId() {
        return id;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public String getProduksi() {
        return produksi;
    }

    public void setProduksi(String produksi) {
        this.produksi = produksi;
    }

    public String getObat_kategori() {
        return obat_kategori;
    }

    public void setObat_kategori(String obat_kategori) {
        this.obat_kategori = obat_kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
