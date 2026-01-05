package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "BIZNESET")
@PrimaryKeyJoinColumn(name = "LOKACION_ID")
public class Biznes extends Lokacion {

    @Id
    @Column(name = "BIZNES_ID")
    private int biznesId;

    @ManyToOne
    @JoinColumn(name = "PERDORUES_ID")
    private Perdorues perdorues;

    @Column(name = "KATEGORIA")
    private String kategoria;

    @Column(name = "PERSHKRIM_SHTESE")
    private String pershkrimShtese;

    @Column(name = "DISPONUESHMERI")
    private String disponueshmeri;

    @ManyToOne
    @JoinColumn(name = "APROVUAR_NGA")
    private Admin aprovuarNga;

    @Column(name = "CMIM_MESATAR")
    private Double cmimMesatar;

    @Column(name = "DATAKRIJIMIT")
    private LocalDate dataKrijimit;

    public Biznes() {
        super();
    }

    public Biznes(
            int lokacionId, String emri, String pershkrimi, Double latitude, Double longitude,
            String tipi, String orari, String adresa, int biznesId, Perdorues perdorues,
            String kategoria, String pershkrimShtese, String disponueshmeri, Admin aprovuarNga,
            Double cmimMesatar, LocalDate dataKrijimit
    ) {
        super(lokacionId, emri, pershkrimi, latitude, longitude, tipi, orari, adresa);
        this.biznesId = biznesId;
        this.perdorues = perdorues;
        this.kategoria = kategoria;
        this.pershkrimShtese = pershkrimShtese;
        this.disponueshmeri = disponueshmeri;
        this.aprovuarNga = aprovuarNga;
        this.cmimMesatar = cmimMesatar;
        this.dataKrijimit = dataKrijimit;
    }

    public int getBiznesId() {
        return biznesId;
    }

    public void setBiznesId(int biznesId) {
        this.biznesId = biznesId;
    }

    public Perdorues getPerdorues() {
        return perdorues;
    }

    public void setPerdorues(Perdorues perdorues) {
        this.perdorues = perdorues;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getPershkrimShtese() {
        return pershkrimShtese;
    }

    public void setPershkrimShtese(String pershkrimShtese) {
        this.pershkrimShtese = pershkrimShtese;
    }

    public String getDisponueshmeri() {
        return disponueshmeri;
    }

    public void setDisponueshmeri(String disponueshmeri) {
        this.disponueshmeri = disponueshmeri;
    }

    public Admin getAprovuarNga() {
        return aprovuarNga;
    }

    public void setAprovuarNga(Admin aprovuarNga) {
        this.aprovuarNga = aprovuarNga;
    }

    public Double getCmimMesatar() {
        return cmimMesatar;
    }

    public void setCmimMesatar(Double cmimMesatar) {
        this.cmimMesatar = cmimMesatar;
    }

    public LocalDate getDataKrijimit() {
        return dataKrijimit;
    }

    public void setDataKrijimit(LocalDate dataKrijimit) {
        this.dataKrijimit = dataKrijimit;
    }
}
