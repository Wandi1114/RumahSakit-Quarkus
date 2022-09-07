package models;

import javax.persistence.*;

@Entity
@Table(name = "coba")
public class Coba extends auditModels{
    @Id
    @SequenceGenerator(name="coba_seq", sequenceName = "coba_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "coba_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(255)")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
