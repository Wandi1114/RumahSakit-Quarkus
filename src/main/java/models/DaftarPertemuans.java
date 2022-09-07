package models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "daftar_pertemuan")
public class DaftarPertemuans extends auditModels implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="daftar_pertemuan_seq", sequenceName = "daftar_pertemuan_sequence", allocationSize = 1)
    @GeneratedValue(generator = "daftar_pertemuan_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = Pasiens.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pasien_id", nullable = false)
    private Pasiens pasien_id;

    @ManyToOne(targetEntity = Dokters.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dokter_id", nullable = false)
    private Dokters dokter_id;

    @Column(name = "kategori",columnDefinition = "varchar(255)")
    private String kategori;

    @Column(name = "deskripsi",columnDefinition = "varchar(255)")
    private String deskripsi;

    @Column(name = "tanggal", nullable = false)
    private LocalDate tanggal;

    public Pasiens getPasien_id() {
        return pasien_id;
    }

    public void setPasien_id(Pasiens pasien_id) {
        this.pasien_id = pasien_id;
    }

    public Dokters getDokter_id() {
        return dokter_id;
    }

    public void setDokter_id(Dokters dokter_id) {
        this.dokter_id = dokter_id;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }
}
