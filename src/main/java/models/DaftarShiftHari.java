package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "daftar_shift_hari")
public class DaftarShiftHari extends auditModels implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="daftar_shift_hari_seq", sequenceName = "daftar_shift_hari_sequence", allocationSize = 1)
    @GeneratedValue(generator = "daftar_shift_hari_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = DaftarShifts.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "daftar_shift_id", nullable = false)
    private DaftarShifts daftar_shift_id;

    @Column(name = "hari", columnDefinition = "varchar(20)")
    private String hari;

    public DaftarShifts getDaftar_shift_id() {
        return daftar_shift_id;
    }

    public void setDaftar_shift_id(DaftarShifts daftar_shift_id) {
        this.daftar_shift_id = daftar_shift_id;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }
}
