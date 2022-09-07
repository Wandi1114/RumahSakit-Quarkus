package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pasien")
public class Pasiens extends auditModels implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="pasien_seq", sequenceName = "pasien_sequence", allocationSize = 1)
    @GeneratedValue(generator = "pasien_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nama_lengkap", columnDefinition = "varchar(255)")
    private String nama_lengkap;

    @Column(name = "gender", columnDefinition = "varchar(255)")
    private String gender;

    @Column(name = "status", columnDefinition = "varchar(255)")
    private String status;

    @Column(name = "address", columnDefinition = "varchar(255)")
    private String address;

    @Column(name = "email",unique = true, columnDefinition = "varchar(255)")
    private String email;

    @Column(name = "phone_number", columnDefinition = "varchar(255)",unique = true)
    private String phone_number;

    @Column(name = "is_cover_bpjs", columnDefinition = "boolean default false")
    private Boolean is_cover_bpjs;

    public Long getId() {
        return id;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Boolean getIs_cover_bpjs() {
        return is_cover_bpjs;
    }

    public void setIs_cover_bpjs(Boolean is_cover_bpjs) {
        this.is_cover_bpjs = is_cover_bpjs;
    }
}
