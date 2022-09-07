package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jadwal_praktik")
public class JadwalPraktiks extends auditModels implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="jadwal_praktik_seq", sequenceName = "jadwal_praktik_sequence", allocationSize = 1)
    @GeneratedValue(generator = "jadwal_praktik_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "hari", columnDefinition = "varchar(20)")
    private String hari;

    @Column(name = "start_time", columnDefinition = "timestamp")
    private String start_time;

    @Column(name = "end_time", columnDefinition = "timestamp")
    private String end_time;

    @Column(name = "deskripsi", columnDefinition = "varchar(255)")
    private String deskripsi;

    @ManyToOne(targetEntity = Dokters.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dokter_id", nullable = false)
    private Dokters dokter_id;
}
