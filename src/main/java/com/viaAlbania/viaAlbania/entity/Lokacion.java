package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LOKACIONE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Lokacion {

    @Id
    @Column(name = "LOKACION_ID")
    private int lokacionId;

    @Column(name = "EMRI")
    private String emri;

    @Column(name = "PERSHKRIMI")
    private String pershkrimi;

    @Column(name = "LATITUDE", nullable = false)
    private Double latitude;

    @Column(name = "LONGITUDE", nullable = false)
    private Double longitude;

    @Column(name = "TIPI")
    private String tipi;

    @Column(name = "ORARI")
    private String orari;

    @Column(name = "ADRESA")
    private String adresa;

    public Lokacion() {
    }

    public Lokacion(int lokacionId, String emri, String pershkrimi, Double latitude,
            Double longitude, String tipi, String orari, String adresa) {
        this.lokacionId = lokacionId;
        this.emri = emri;
        this.pershkrimi = pershkrimi;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tipi = tipi;
        this.orari = orari;
        this.adresa = adresa;
    }

    public int getLokacionId() {
        return lokacionId;
    }

    public void setLokacionId(int lokacionId) {
        this.lokacionId = lokacionId;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTipi() {
        return tipi;
    }

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }

    public String getOrari() {
        return orari;
    }

    public void setOrari(String orari) {
        this.orari = orari;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
