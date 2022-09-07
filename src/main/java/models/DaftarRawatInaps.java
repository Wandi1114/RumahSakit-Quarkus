package models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "daftar_rawat_inap")
public class DaftarRawatInaps extends auditModels implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="daftar_rawat_inap_seq", sequenceName = "daftar_rawat_inap_sequence", allocationSize = 1)
    @GeneratedValue(generator = "daftar_rawat_inap_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = Pasiens.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pasien_id", nullable = false)
    private Pasiens pasien_id;

    @ManyToOne(targetEntity = RuangInaps.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ruang_inap_id", nullable = false)
    private RuangInaps ruang_inap_id;

    @ManyToOne(targetEntity = Dokters.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dokter_id", nullable = false)
    private Dokters dokter_id;

    @ManyToOne(targetEntity = Perawats.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "perawat_satu_id", nullable = true)
    private Perawats perawat_satu_id;

    @ManyToOne(targetEntity = Perawats.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "perawat_dua_id", nullable = true)
    private Perawats perawat_dua_id;

    @Column(name = "start_datetime", nullable = false)
    private LocalDateTime start_datetime;

    @Column(name = "end_datetime", nullable = true)
    private LocalDateTime end_datetime;

    @Column(name = "is_checkout", nullable = false)
    private Boolean is_checkout;

    public Pasiens getPasien_id() {
        return pasien_id;
    }

    public void setPasien_id(Pasiens pasien_id) {
        this.pasien_id = pasien_id;
    }

    public RuangInaps getRuang_inap_id() {
        return ruang_inap_id;
    }

    public void setRuang_inap_id(RuangInaps ruang_inap_id) {
        this.ruang_inap_id = ruang_inap_id;
    }

    public Dokters getDokter_id() {
        return dokter_id;
    }

    public void setDokter_id(Dokters dokter_id) {
        this.dokter_id = dokter_id;
    }

    public Perawats getPerawat_satu_id() {
        return perawat_satu_id;
    }

    public void setPerawat_satu_id(Perawats perawat_satu_id) {
        this.perawat_satu_id = perawat_satu_id;
    }

    public Perawats getPerawat_dua_id() {
        return perawat_dua_id;
    }

    public void setPerawat_dua_id(Perawats perawat_dua_id) {
        this.perawat_dua_id = perawat_dua_id;
    }

    public LocalDateTime getStart_datetime() {
        return start_datetime;
    }

    public void setStart_datetime(LocalDateTime start_datetime) {
        this.start_datetime = start_datetime;
    }

    public LocalDateTime getEnd_datetime() {
        return end_datetime;
    }

    public void setEnd_datetime(LocalDateTime end_datetime) {
        this.end_datetime = end_datetime;
    }

    public Boolean getIs_checkout() {
        return is_checkout;
    }

    public void setIs_checkout(Boolean is_checkout) {
        this.is_checkout = is_checkout;
    }
}
