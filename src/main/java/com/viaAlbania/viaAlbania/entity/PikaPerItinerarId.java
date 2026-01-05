package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PikaPerItinerarId implements Serializable {

    @Column(name = "ITINERAR_ID")
    private int itinerarId;

    @Column(name = "LOKACIONE_ID")
    private int lokacionId;

    public PikaPerItinerarId() {
    }

    public PikaPerItinerarId(int itinerarId, int lokacionId) {
        this.itinerarId = itinerarId;
        this.lokacionId = lokacionId;
    }

    public int getItinerarId() {
        return itinerarId;
    }

    public void setItinerarId(int itinerarId) {
        this.itinerarId = itinerarId;
    }

    public int getLokacionId() {
        return lokacionId;
    }

    public void setLokacionId(int lokacionId) {
        this.lokacionId = lokacionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PikaPerItinerarId)) return false;
        PikaPerItinerarId that = (PikaPerItinerarId) o;
        return itinerarId == that.itinerarId && lokacionId == that.lokacionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itinerarId, lokacionId);
    }
}
