package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PAGESAT")
public class Pagesa {

    @Id
    @Column(name = "PAGESA_ID")
    private int pagesaId;

    @Column(name = "SHUMA")
    private Double shuma;

    @Column(name = "DATA_PAGESES")
    private LocalDate dataPageses;

    @Column(name = "PAYPAL_TOKEN_ID")
    private String paypalTokenId;

    @Column(name = "STATUSI")
    private String statusi;

    // No-arg constructor (required by JPA)
    public Pagesa() {
    }

    // Full constructor
    public Pagesa(int pagesaId, Double shuma, LocalDate dataPageses,
                  String paypalTokenId, String statusi) {
        this.pagesaId = pagesaId;
        this.shuma = shuma;
        this.dataPageses = dataPageses;
        this.paypalTokenId = paypalTokenId;
        this.statusi = statusi;
    }

    public int getPagesaId() {
        return pagesaId;
    }

    public void setPagesaId(int pagesaId) {
        this.pagesaId = pagesaId;
    }

    public Double getShuma() {
        return shuma;
    }

    public void setShuma(Double shuma) {
        this.shuma = shuma;
    }

    public LocalDate getDataPageses() {
        return dataPageses;
    }

    public void setDataPageses(LocalDate dataPageses) {
        this.dataPageses = dataPageses;
    }

    public String getPaypalTokenId() {
        return paypalTokenId;
    }

    public void setPaypalTokenId(String paypalTokenId) {
        this.paypalTokenId = paypalTokenId;
    }

    public String getStatusi() {
        return statusi;
    }

    public void setStatusi(String statusi) {
        this.statusi = statusi;
    }
}

