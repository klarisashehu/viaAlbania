package com.viaAlbania.viaAlbania.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PERGJEGJES_LOKAL")
@PrimaryKeyJoinColumn(name = "PERDORUES_ID")
public class PergjegjesLokal extends Perdorues {

    @Column(name = "PERGJEGJES_ID")
    private int pergjegjesId;

    @Column(name = "BASHKIA")
    private String bashkia;

    public PergjegjesLokal() {
        super();
    }

    public PergjegjesLokal(int perdoruesId, String roli, String emer, String mbiemer,
            String email, String fjalkalimi, LocalDate dataKrijimit,
            int pergjegjesId, String bashkia) {
        super(perdoruesId, roli, emer, mbiemer, email, fjalkalimi, dataKrijimit);
        this.pergjegjesId = pergjegjesId;
        this.bashkia = bashkia;
    }

    public int getPergjegjesId() {
        return pergjegjesId;
    }

    public void setPergjegjesId(int pergjegjesId) {
        this.pergjegjesId = pergjegjesId;
    }

    public String getBashkia() {
        return bashkia;
    }

    public void setBashkia(String bashkia) {
        this.bashkia = bashkia;
    }
}
