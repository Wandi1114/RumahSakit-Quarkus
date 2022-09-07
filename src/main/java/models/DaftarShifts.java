package models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "daftar_shift")
public class DaftarShifts extends auditModels implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="daftar_shift_seq", sequenceName = "daftar_shift_sequence", allocationSize = 1)
    @GeneratedValue(generator = "daftar_shift_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = Perawats.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "perawat_id", nullable = false)
    private Perawats perawat_id;

    @ManyToOne(targetEntity = Staffs.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staffs staff_id;

    @Column(name = "start_datetime", nullable = false)
    private LocalDateTime start_datetime;

    @Column(name = "end_datetime", nullable = true)
    private LocalDateTime end_datetime;
}
