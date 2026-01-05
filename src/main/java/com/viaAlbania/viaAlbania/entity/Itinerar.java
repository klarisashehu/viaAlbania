package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ITINERARET")
public class Itinerar {

    @Id
    @Column(name = "ITINERAR_ID")
    private int itinerarId;

    @ManyToOne
    @JoinColumn(name = "TURIST_ID")
    private Turist turist;

    @Column(name = "DATA_FILLIMI")
    private LocalDate dataFillimi;

    @Column(name = "DATA_MBARIMI")
    private LocalDate dataMbarimi;

    @Column(name = "KOSTO_TOTALE")
    private Double kostoTotale;

    @Column(name = "DATA_GJENERIMIT")
    private LocalDate dataGjenerimit;

    @Column(name = "RAPORT_PERMBLEDHES")
    private String raportPermbledhes;

    public Itinerar() {
    }

    public Itinerar(
            int itinerarId, Turist turist, LocalDate dataFillimi, LocalDate dataMbarimi,
            Double kostoTotale, LocalDate dataGjenerimit, String raportPermbledhes) {
        this.itinerarId = itinerarId;
        this.turist = turist;
        this.dataFillimi = dataFillimi;
        this.dataMbarimi = dataMbarimi;
        this.kostoTotale = kostoTotale;
        this.dataGjenerimit = dataGjenerimit;
        this.raportPermbledhes = raportPermbledhes;
    }

    public int getItinerarId() {
        return itinerarId;
    }

    public void setItinerarId(int itinerarId) {
        this.itinerarId = itinerarId;
    }

    public Turist getTurist() {
        return turist;
    }

    public void setTurist(Turist turist) {
        this.turist = turist;
    }

    public LocalDate getDataFillimi() {
        return dataFillimi;
    }

    public void setDataFillimi(LocalDate dataFillimi) {
        this.dataFillimi = dataFillimi;
    }

    public LocalDate getDataMbarimi() {
        return dataMbarimi;
    }

    public void setDataMbarimi(LocalDate dataMbarimi) {
        this.dataMbarimi = dataMbarimi;
    }

    public Double getKostoTotale() {
        return kostoTotale;
    }

    public void setKostoTotale(Double kostoTotale) {
        this.kostoTotale = kostoTotale;
    }

    public LocalDate getDataGjenerimit() {
        return dataGjenerimit;
    }

    public void setDataGjenerimit(LocalDate dataGjenerimit) {
        this.dataGjenerimit = dataGjenerimit;
    }

    public String getRaportPermbledhes() {
        return raportPermbledhes;
    }

    public void setRaportPermbledhes(String raportPermbledhes) {
        this.raportPermbledhes = raportPermbledhes;
    }
}
