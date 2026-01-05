package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "HISTORIK_PAGESASH")
public class HistorikPagesash {

    @Id
    @Column(name = "HISTORIK_PAGESASH_ID")
    private int historikPagesashId;

    @Column(name = "SHUMA")
    private Double shuma;

    @Column(name = "DATA_PAGESES")
    private LocalDate dataPageses;

    @OneToOne
    @JoinColumn(name = "PAGESA_ID", foreignKey = @ForeignKey(name = "FK_HIST_PAGESA"), nullable = true)
    private Pagesa pagesa;

    public HistorikPagesash() {
    }

    // Full constructor
    public HistorikPagesash(int historikPagesashId, Double shuma, LocalDate dataPageses, Pagesa pagesa) {
        this.historikPagesashId = historikPagesashId;
        this.shuma = shuma;
        this.dataPageses = dataPageses;
        this.pagesa = pagesa;
    }

    public int getHistorikPagesashId() {
        return historikPagesashId;
    }

    public void setHistorikPagesashId(int historikPagesashId) {
        this.historikPagesashId = historikPagesashId;
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

    public Pagesa getPagesa() {
        return pagesa;
    }

    public void setPagesa(Pagesa pagesa) {
        this.pagesa = pagesa;
    }
}
