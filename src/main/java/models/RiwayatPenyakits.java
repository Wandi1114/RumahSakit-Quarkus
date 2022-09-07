package models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "riwayat_penyakit")
public class RiwayatPenyakits extends auditModels implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="riwayat_penyakit_seq", sequenceName = "riwayat_penyakit_sequence", allocationSize = 1)
    @GeneratedValue(generator = "riwayat_penyakit_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = Pasiens.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pasien_id", nullable = false)
    private Pasiens pasien_id;

    @Column(name = "nama", columnDefinition = "varchar(255)")
    private String nama;

    @Column(name = "deskripsi", columnDefinition = "varchar(255)")
    private String deskripsi;

    @Column(name = "awal_date", columnDefinition = "varchar(255)")
    private LocalDate awal_date;

    @Column(name = "sembuh_date", columnDefinition = "varchar(255)")
    private LocalDate sembuh_date;

    public Pasiens getPasien_id() {
        return pasien_id;
    }

    public void setPasien_id(Pasiens pasien_id) {
        this.pasien_id = pasien_id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public LocalDate getAwal_date() {
        return awal_date;
    }

    public void setAwal_date(LocalDate awal_date) {
        this.awal_date = awal_date;
    }

    public LocalDate getSembuh_date() {
        return sembuh_date;
    }

    public void setSembuh_date(LocalDate sembuh_date) {
        this.sembuh_date = sembuh_date;
    }

    //    @Column(name = "deskripsi", columnDefinition = "varchar(255)")
//    private String deskripsi;
//
//    @ManyToOne(targetEntity = Dokters.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "dokter_id", nullable = false)
//    private Dokters dokter_id;
}
