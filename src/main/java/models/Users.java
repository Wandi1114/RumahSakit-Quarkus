package models;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import org.hibernate.Session;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;

@Entity
@Table(name = "users")
@UserDefinition
public class Users extends auditModels implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "user_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "userSeq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(255)")
    private String name;

    @Username
    @Column(name = "username",unique = true, nullable = false, columnDefinition = "varchar(50)")
    private String username;

    @Password
    @Column(name = "password", nullable = false, columnDefinition = "varchar(255)")
    private String password;

    @Column(name = "email",unique = true, columnDefinition = "varchar(255)")
    private String email;

    @Column(name = "phone_number",unique = true, columnDefinition = "varchar(255)")
    private String phone_number;

    @Roles
    @Column(name = "user_type", columnDefinition = "varchar(50) default 'admin'")
    private String user_type;

    public Users(){
        this.id = null;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}
