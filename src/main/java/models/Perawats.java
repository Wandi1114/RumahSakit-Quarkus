package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "perawat")
public class Perawats extends AuditPegawaiModels implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="perawat_seq", sequenceName = "perawat_sequence", allocationSize = 1)
    @GeneratedValue(generator = "perawat_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "gender", columnDefinition = "varchar(255)")
    private String gender;

    public Long getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
