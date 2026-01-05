package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PIKAT_TURISTIKE")
@PrimaryKeyJoinColumn(name = "LOKACION_ID")
public class PikaTuristike extends Lokacion {

    @Id
    @Column(name = "PIKE_TURISTIKE_ID")
    private int pikeTuristikeId;

    @Column(name = "KATEGORIA")
    private String kategoria;

    @Column(name = "CMIMI")
    private Double cmimi;

    @Column(name = "BASHKIA")
    private String bashkia;

    @ManyToOne
    @JoinColumn(name = "PERGJEGJES_LOKAL")
    private PergjegjesLokal pergjegjesLokal;

    @Column(name = "DATA_KRIJIMIT")
    private LocalDate dataKrijimit;

    public PikaTuristike() {
        super();
    }

    public PikaTuristike(int lokacionId, String emri, String pershkrimi, Double latitude,
            Double longitude, String tipi, String orari, String adresa,
            int pikeTuristikeId, String kategoria, Double cmimi,
            String bashkia, PergjegjesLokal pergjegjesLokal, LocalDate dataKrijimit) {
        super(lokacionId, emri, pershkrimi, latitude, longitude, tipi, orari, adresa);
        this.pikeTuristikeId = pikeTuristikeId;
        this.kategoria = kategoria;
        this.cmimi = cmimi;
        this.bashkia = bashkia;
        this.pergjegjesLokal = pergjegjesLokal;
        this.dataKrijimit = dataKrijimit;
    }

    public int getPikeTuristikeId() {
        return pikeTuristikeId;
    }

    public void setPikeTuristikeId(int pikeTuristikeId) {
        this.pikeTuristikeId = pikeTuristikeId;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public Double getCmimi() {
        return cmimi;
    }

    public void setCmimi(Double cmimi) {
        this.cmimi = cmimi;
    }

    public String getBashkia() {
        return bashkia;
    }

    public void setBashkia(String bashkia) {
        this.bashkia = bashkia;
    }

    public PergjegjesLokal getPergjegjesLokal() {
        return pergjegjesLokal;
    }

    public void setPergjegjesLokal(PergjegjesLokal pergjegjesLokal) {
        this.pergjegjesLokal = pergjegjesLokal;
    }

    public LocalDate getDataKrijimit() {
        return dataKrijimit;
    }

    public void setDataKrijimit(LocalDate dataKrijimit) {
        this.dataKrijimit = dataKrijimit;
    }
}
