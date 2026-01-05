package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "FEEDBACKS")
public class Feedback {

    @Id
    @Column(name = "FEEDBACK_ID")
    private int feedbackId;

    @ManyToOne
    @JoinColumn(name = "ITINERAR_ID")
    private Itinerar itinerar;

    @ManyToOne
    @JoinColumn(name = "TURIST_ID")
    private Turist turist;

    @Column(name = "VLERESIMI")
    private int vleresimi;

    @Column(name = "KOMENTI", length = 400)
    private String komenti;

    @Column(name = "DATA_FILLIMIT")
    private LocalDate dataFillimit;

    public Feedback() {
    }

    public Feedback(int feedbackId, Itinerar itinerar, Turist turist, int vleresimi,
                    String komenti, LocalDate dataFillimit) {
        this.feedbackId = feedbackId;
        this.itinerar = itinerar;
        this.turist = turist;
        this.vleresimi = vleresimi;
        this.komenti = komenti;
        this.dataFillimit = dataFillimit;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
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

    public int getVleresimi() {
        return vleresimi;
    }

    public void setVleresimi(int vleresimi) {
        this.vleresimi = vleresimi;
    }

    public String getKomenti() {
        return komenti;
    }

    public void setKomenti(String komenti) {
        this.komenti = komenti;
    }

    public LocalDate getDataFillimit() {
        return dataFillimit;
    }

    public void setDataFillimit(LocalDate dataFillimit) {
        this.dataFillimit = dataFillimit;
    }
}
