package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PagesaPerItinerarId implements Serializable {
    private int itinerarId;
    private int turistId;

    public PagesaPerItinerarId() {
    }

    public PagesaPerItinerarId(int itinerarId, int turistId) {
        this.itinerarId = itinerarId;
        this.turistId = turistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PagesaPerItinerarId)) return false;
        PagesaPerItinerarId that = (PagesaPerItinerarId) o;
        return itinerarId == that.itinerarId && turistId == that.turistId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itinerarId, turistId);
    }

    public int getItinerarId() {
        return itinerarId;
    }
    public void setItinerarId(int itinerarId) {
        this.itinerarId = itinerarId;
    }
    public int getTuristId() {
        return turistId;
    }
    public void setTuristId(int turistId) {
        this.turistId = turistId;
    }
}
