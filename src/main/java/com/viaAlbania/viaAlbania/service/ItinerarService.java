package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.Itinerar;
import com.viaAlbania.viaAlbania.entity.Turist;
import com.viaAlbania.viaAlbania.repository.ItinerarRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ItinerarService {

    @Autowired
    private ItinerarRep itinerarRep;

    public Itinerar ruajItinerar(Itinerar itinerar) {
        itinerar.setDataGjenerimit(LocalDate.now());
        return itinerarRep.save(itinerar);
    }

    public Itinerar gjeneroItinerar(Turist turist, LocalDate start, LocalDate end, Double kostoTotale, String raport) {
        Itinerar itinerar = new Itinerar();
        itinerar.setTurist(turist);
        itinerar.setDataFillimi(start);
        itinerar.setDataMbarimi(end);
        itinerar.setKostoTotale(kostoTotale);
        itinerar.setRaportPermbledhes(raport);
        itinerar.setDataGjenerimit(LocalDate.now());
        return itinerarRep.save(itinerar);
    }

    public List<Itinerar> merrTeGjitha() {
        return itinerarRep.findAll();
    }

    public List<Itinerar> merrSipasTuristi(int turistId) {
        return itinerarRep.findByTurist_TuristId(turistId);
    }

    public Optional<Itinerar> merrMeId(int id) {
        return itinerarRep.findById(id);
    }
}
