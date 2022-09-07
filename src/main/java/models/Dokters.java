package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dokter")
public class Dokters extends AuditPegawaiModels implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="dokter_seq", sequenceName = "dokter_sequence", allocationSize = 1)
    @GeneratedValue(generator = "dokter_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "is_spesialis",columnDefinition = "boolean default false")
    private Boolean is_spesialis;

    @Column(name = "spesialis_nama",columnDefinition = "varchar(255)")
    private String spesialis_nama;

    public Long getId() {
        return id;
    }

    public Boolean getIs_spesialis() {
        return is_spesialis;
    }

    public void setIs_spesialis(Boolean is_spesialis) {
        this.is_spesialis = is_spesialis;
    }

    public String getSpesialis_nama() {
        return spesialis_nama;
    }

    public void setSpesialis_nama(String spesialis_nama) {
        this.spesialis_nama = spesialis_nama;
    }
}
