package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PERDORUESIT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Perdorues {

    @Id
    @Column(name = "PERDORUES_ID")
    private int perdoruesId;

    @Column(name = "ROLI")
    private String roli;

    @Column(name = "EMER")
    private String emer;

    @Column(name = "MBIEMER")
    private String mbiemer;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "FJALKALIMI")
    private String fjalkalimi;

    @Column(name = "DATA_KRIJIMIT")
    private LocalDate dataKrijimit;  // <-- changed from Date to LocalDate

    public Perdorues() {
    }

    public Perdorues(int perdoruesId, String roli, String emer, String mbiemer,
                     String email, String fjalkalimi, LocalDate dataKrijimit) {
        this.perdoruesId = perdoruesId;
        this.roli = roli;
        this.emer = emer;
        this.mbiemer = mbiemer;
        this.email = email;
        this.fjalkalimi = fjalkalimi;
        this.dataKrijimit = dataKrijimit;
    }

    public int getPerdoruesId() {
        return perdoruesId;
    }
    public void setPerdoruesId(int perdoruesId) {
        this.perdoruesId = perdoruesId;
    }

    public String getRoli() {
        return roli;
    }
    public void setRoli(String roli) {
        this.roli = roli;
    }

    public String getEmer() {
        return emer;
    }
    public void setEmer(String emer) {
        this.emer = emer;
    }

    public String getMbiemer() {
        return mbiemer;
    }
    public void setMbiemer(String mbiemer) {
        this.mbiemer = mbiemer;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFjalkalimi() {
        return fjalkalimi;
    }
    public void setFjalkalimi(String fjalkalimi) {
        this.fjalkalimi = fjalkalimi;
    }

    public LocalDate getDataKrijimit() {
        return dataKrijimit;
    }
    public void setDataKrijimit(LocalDate dataKrijimit) {
        this.dataKrijimit = dataKrijimit;
    }
}
