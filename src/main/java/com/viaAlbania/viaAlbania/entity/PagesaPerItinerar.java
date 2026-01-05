package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PAGESA_PER_ITINERAR")
public class PagesaPerItinerar {

    @EmbeddedId
    private PagesaPerItinerarId id;

    @ManyToOne
    @MapsId("pagesaId")
    @JoinColumn(name = "PAGESA_ID")
    private Pagesa pagesa;

    @ManyToOne
    @MapsId("itinerarId")
    @JoinColumn(name = "ITINERAR_ID")
    private Itinerar itinerar;

    @ManyToOne
    @MapsId("turistId")
    @JoinColumn(name = "TURIST_ID")
    private Turist turist;

    @Column(name = "LLOJI_SHERBIMIT")
    private String llojiSherbimit;

    public PagesaPerItinerar() {}

    public PagesaPerItinerar(Pagesa pagesa, Itinerar itinerar, Turist turist, String llojiSherbimit) {
        this.pagesa = pagesa;
        this.itinerar = itinerar;
        this.turist = turist;
        this.llojiSherbimit = llojiSherbimit;
        this.id = new PagesaPerItinerarId(itinerar.getItinerarId(), turist.getTuristId());
    }


    public PagesaPerItinerarId getId() {
        return id;
    }
    public void setId(PagesaPerItinerarId id) {
        this.id = id;
    }
    public Pagesa getPagesa() {
        return pagesa;
    }
    public void setPagesa(Pagesa pagesa) {
        this.pagesa = pagesa;
    }
    public Itinerar getItinerar() {
        return itinerar;
    }
    public void setItinerar(Itinerar itinerar) {
        this.itinerar = itinerar;
    }
    public Turist getTurist() {
        return turist;
    }
    public void setTurist(Turist turist) {
        this.turist = turist;
    }
    public String getLlojiSherbimit() {
        return llojiSherbimit;
    }
    public void setLlojiSherbimit(String llojiSherbimit) {
        this.llojiSherbimit = llojiSherbimit;
    }
}
