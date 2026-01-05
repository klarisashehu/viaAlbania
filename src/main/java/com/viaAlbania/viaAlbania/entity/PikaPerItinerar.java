package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PIKAT_PER_ITINERAR")
public class PikaPerItinerar {

    @EmbeddedId
    private PikaPerItinerarId id;

    @ManyToOne
    @MapsId("itinerarId")
    @JoinColumn(name = "ITINERAR_ID")
    private Itinerar itinerar;

    @ManyToOne
    @MapsId("lokacionId")
    @JoinColumn(name = "LOKACIONE_ID")
    private Lokacion lokacion;

    @Column(name = "RENDI")
    private Integer rendi;

    @Column(name = "CHECKIN")
    private Boolean checkin = false;

    @Column(name = "CHECKIN_TIME")
    private LocalDateTime checkinTime;

    public PikaPerItinerar() {
    }

    public PikaPerItinerar(Itinerar itinerar, Lokacion lokacion, Integer rendi, Boolean checkin, LocalDateTime checkinTime) {
        this.itinerar = itinerar;this.lokacion = lokacion; this.rendi = rendi;
        this.checkin = checkin; this.checkinTime = checkinTime;
        this.id = new PikaPerItinerarId(itinerar.getItinerarId(), lokacion.getLokacionId());
    }

    // Getters and setters
    public PikaPerItinerarId getId() {
        return id;
    }

    public void setId(PikaPerItinerarId id) {
        this.id = id;
    }

    public Itinerar getItinerar() {
        return itinerar;
    }

    public void setItinerar(Itinerar itinerar) {
        this.itinerar = itinerar;
    }

    public Lokacion getLokacion() {
        return lokacion;
    }

    public void setLokacion(Lokacion lokacion) {
        this.lokacion = lokacion;
    }

    public Integer getRendi() {
        return rendi;
    }

    public void setRendi(Integer rendi) {
        this.rendi = rendi;
    }

    public Boolean getCheckin() {
        return checkin;
    }

    public void setCheckin(Boolean checkin) {
        this.checkin = checkin;
    }

    public LocalDateTime getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(LocalDateTime checkinTime) {
        this.checkinTime = checkinTime;
    }
}
