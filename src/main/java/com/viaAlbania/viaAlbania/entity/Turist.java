package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TURISTET")
@PrimaryKeyJoinColumn(name = "PERDORUES_ID")
public class Turist extends Perdorues {

    @Column(name = "TURIST_ID")
    private int turistId;

    @Column(name = "BUXHETI_MIN")
    private Double buxhetiMin;

    @Column(name = "BUXHETI_MAX")
    private Double buxhetiMax;

    @Column(name = "PREFERENCAT")
    private String preferencat;

    @Column(name = "DESTINACIONET")
    private String destinacionet;

    @Column(name = "KOHEZGJATJA_DITE")
    private Integer kohezgjatjaDite;

    @Column(name = "HISTORI_UDHETIME")
    private String historiUdhetime;

    // Required by JPA
    public Turist() {
        super();
    }

    public Turist(int perdoruesId, String roli, String emer, String mbiemer, String email,
            String fjalkalimi, LocalDate dataKrijimit, int turistId, Double buxhetiMin,
            Double buxhetiMax, String preferencat, String destinacionet,
            Integer kohezgjatjaDite, String historiUdhetime) {
        super(perdoruesId, roli, emer, mbiemer, email, fjalkalimi, dataKrijimit);
        this.turistId = turistId;
        this.buxhetiMin = buxhetiMin;
        this.buxhetiMax = buxhetiMax;
        this.preferencat = preferencat;
        this.destinacionet = destinacionet;
        this.kohezgjatjaDite = kohezgjatjaDite;
        this.historiUdhetime = historiUdhetime;
    }

    public int getTuristId() {
        return turistId;
    }

    public void setTuristId(int turistId) {
        this.turistId = turistId;
    }

    public Double getBuxhetiMin() {
        return buxhetiMin;
    }

    public void setBuxhetiMin(Double buxhetiMin) {
        this.buxhetiMin = buxhetiMin;
    }

    public Double getBuxhetiMax() {
        return buxhetiMax;
    }

    public void setBuxhetiMax(Double buxhetiMax) {
        this.buxhetiMax = buxhetiMax;
    }

    public String getPreferencat() {
        return preferencat;
    }

    public void setPreferencat(String preferencat) {
        this.preferencat = preferencat;
    }

    public String getDestinacionet() {
        return destinacionet;
    }

    public void setDestinacionet(String destinacionet) {
        this.destinacionet = destinacionet;
    }

    public Integer getKohezgjatjaDite() {
        return kohezgjatjaDite;
    }

    public void setKohezgjatjaDite(Integer kohezgjatjaDite) {
        this.kohezgjatjaDite = kohezgjatjaDite;
    }

    public String getHistoriUdhetime() {
        return historiUdhetime;
    }

    public void setHistoriUdhetime(String historiUdhetime) {
        this.historiUdhetime = historiUdhetime;
    }
}
