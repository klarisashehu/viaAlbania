package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LINKET_E_JASHTME")
public class LinkJashtem {

    @Id
    @Column(name = "LINK_ID")
    private int linkId;

    @ManyToOne
    @JoinColumn(name = "BIZNES_ID", foreignKey = @ForeignKey(name = "FK_BIZNES_LINK"))
    private Biznes biznes;

    @Column(name = "TIPI")
    private String tipi;

    @Column(name = "LINK")
    private String link;

    public LinkJashtem() {
    }

    public LinkJashtem(int linkId, Biznes biznes, String tipi, String link) {
        this.linkId = linkId;
        this.biznes = biznes;
        this.tipi = tipi;
        this.link = link;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public Biznes getBiznes() {
        return biznes;
    }

    public void setBiznes(Biznes biznes) {
        this.biznes = biznes;
    }

    public String getTipi() {
        return tipi;
    }

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
