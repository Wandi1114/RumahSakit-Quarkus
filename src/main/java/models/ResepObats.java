package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "resep_obat")
public class ResepObats extends auditModels implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="resep_obat_seq", sequenceName = "resep_obat_sequence", allocationSize = 1)
    @GeneratedValue(generator = "resep_obat_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = DaftarPertemuans.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pertemuan_id", nullable = false)
    private DaftarPertemuans pertemuan_id;

    @ManyToOne(targetEntity = Obats.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "obat_id", nullable = false)
    private Obats obat_id;

    @Column(name = "dosis", columnDefinition = "varchar(255)")
    private String dosis;

    @Column(name = "deskripsi", columnDefinition = "varchar(255)")
    private String deskripsi;

//    @Column(name = "deskripsi", columnDefinition = "varchar(255)")
//    private String deskripsi;
//
//    @ManyToOne(targetEntity = Dokters.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "dokter_id", nullable = false)
//    private Dokters dokter_id;
}
