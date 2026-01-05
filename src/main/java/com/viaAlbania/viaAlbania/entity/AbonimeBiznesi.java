package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ABONIME_BIZNESI")
public class AbonimeBiznesi {

    @Id
    @Column(name = "ABONIMI_ID")
    private int abonimiId;

    @ManyToOne
    @JoinColumn(name = "BIZNES_ID")
    private Biznes biznes;

    @ManyToOne
    @JoinColumn(name = "PAGESA_ID")
    private Pagesa pagesa;

    @Column(name = "MUAJI")
    private String muaji;

    @Column(name = "AKTIV")
    private int aktiv;

    public AbonimeBiznesi() {}

    public AbonimeBiznesi(int abonimiId, Biznes biznes, Pagesa pagesa, String muaji, int aktiv) {
        this.abonimiId = abonimiId;
        this.biznes = biznes;
        this.pagesa = pagesa;
        this.muaji = muaji;
        this.aktiv = aktiv;
    }

    public int getAbonimiId() {
        return abonimiId;
    }
    public void setAbonimiId(int abonimiId) {
        this.abonimiId = abonimiId;
    }
    public Biznes getBiznes() {
        return biznes;
    }
    public void setBiznes(Biznes biznes) {
        this.biznes = biznes;
    }
    public Pagesa getPagesa() {
        return pagesa;
    }
    public void setPagesa(Pagesa pagesa) {
        this.pagesa = pagesa;
    }
    public String getMuaji() {
        return muaji;
    }
    public void setMuaji(String muaji) {
        this.muaji = muaji;
    }
    public int getAktiv() {
        return aktiv;
    }
    public void setAktiv(int aktiv) {
        this.aktiv = aktiv;
    }
}
