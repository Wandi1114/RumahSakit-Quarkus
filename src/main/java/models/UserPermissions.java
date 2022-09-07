package models;

import io.vertx.ext.auth.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_permission")
public class UserPermissions extends auditModels implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "user_permissionSeq", sequenceName = "user_permission_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "user_permissionSeq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private Long id;

    @ManyToOne(targetEntity = Users.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(50)")
    private String name;

    public Long getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
