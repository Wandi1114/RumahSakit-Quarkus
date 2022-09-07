package models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class AuditPegawaiModels extends PanacheEntityBase {

    @Column(name = "nama_lengkap", nullable = false, columnDefinition = "varchar(255)")
    String nama_lengkap;

    @Column(name = "email",unique = true, columnDefinition = "varchar(255)")
    String email;

    @Column(name = "phone_number",unique = true, columnDefinition = "varchar(255)")
    String phone_number;

    @Column(name = "status", columnDefinition = "varchar(255)")
    String status;

    @Column(name = "gaji", nullable = false)
    Long gaji;


    @CreationTimestamp
    @Column(name = "created_datetime",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    @Column(name = "updated_datetime", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedDateTime;

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getGaji() {
        return gaji;
    }

    public void setGaji(Long gaji) {
        this.gaji = gaji;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }
}
