package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ADMINS")
public class Admin {

    @Id
    @Column(name = "ADMIN_ID")
    private int adminId;

    @Column(name = "EMER")
    private String emer;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "FJALKALIMI")
    private String fjalkalimi;

    @Column(name = "AKTIV")
    private boolean aktiv; // mapped NUMBER(1) → boolean in Java

    @Column(name = "DATA_KRIJIMIT")
    private LocalDate dataKrijimit;


    public Admin() {
    }

    public Admin(int adminId, String emer, String email, String fjalkalimi, boolean aktiv, LocalDate dataKrijimit) {
        this.adminId = adminId;
        this.emer = emer;
        this.email = email;
        this.fjalkalimi = fjalkalimi;
        this.aktiv = aktiv;
        this.dataKrijimit = dataKrijimit;
    }

    public int getAdminId() { return adminId; }
    public void setAdminId(int adminId) { this.adminId = adminId; }

    public String getEmer() { return emer; }
    public void setEmer(String emer) { this.emer = emer; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFjalkalimi() { return fjalkalimi; }
    public void setFjalkalimi(String fjalkalimi) { this.fjalkalimi = fjalkalimi; }

    public boolean isAktiv() { return aktiv; }
    public void setAktiv(boolean aktiv) { this.aktiv = aktiv; }

    public LocalDate getDataKrijimit() { return dataKrijimit; }
    public void setDataKrijimit(LocalDate dataKrijimit) { this.dataKrijimit = dataKrijimit; }
}