package models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "staff")
public class Staffs extends AuditPegawaiModels implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="staff_seq", sequenceName = "staff_sequence", allocationSize = 1)
    @GeneratedValue(generator = "staff_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "gender", columnDefinition = "varchar(255)")
    private String gender;

    @Column(name = "posisi", columnDefinition = "varchar(255)")
    private String posisi;

    @Column(name = "start_datetime")
    private LocalDateTime start_datetime;

    @Column(name = "end_datetime")
    private LocalDateTime end_datetime;

    public Long getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
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
}
