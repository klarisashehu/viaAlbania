package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.PagesaPerItinerar;
import com.viaAlbania.viaAlbania.entity.PagesaPerItinerarId;
import com.viaAlbania.viaAlbania.repository.PagesaPerItinerarRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagesaPerItinerarService {

    @Autowired
    private PagesaPerItinerarRep rep;

    public PagesaPerItinerar ruaj(PagesaPerItinerar ppi) {
        return rep.save(ppi);
    }

    public PagesaPerItinerar procesoPages(PagesaPerItinerarId id, String statusi) {
        Optional<PagesaPerItinerar> opt = rep.findById(id);
        if (opt.isPresent()) {
            PagesaPerItinerar ppi = opt.get();
            ppi.getPagesa().setStatusi(statusi);
            return rep.save(ppi);
        }
        return null;
    }

    public String gjeneroFaturen(PagesaPerItinerarId id) {
        Optional<PagesaPerItinerar> opt = rep.findById(id);
        if (opt.isPresent()) {
            PagesaPerItinerar ppi = opt.get();
            return "Fature PagesaPerItinerar\n" +
                    "Turist: " + ppi.getTurist().getEmer() + "\n" +
                    "Itinerar ID: " + ppi.getItinerar().getItinerarId() + "\n" +
                    "Pagesa ID: " + ppi.getPagesa().getPagesaId() + "\n" +
                    "Shuma: " + ppi.getPagesa().getShuma() + "\n" +
                    "Statusi: " + ppi.getPagesa().getStatusi() + "\n" +
                    "Lloji Sherbimit: " + ppi.getLlojiSherbimit();
        }
        return "Pagesa per itinerar nuk u gjet";
    }

    public PagesaPerItinerar zgjidhLlojinESherbimit(PagesaPerItinerarId id, String lloji) {
        Optional<PagesaPerItinerar> opt = rep.findById(id);
        if (opt.isPresent()) {
            PagesaPerItinerar ppi = opt.get();
            ppi.setLlojiSherbimit(lloji);
            return rep.save(ppi);
        }
        return null;
    }

    public Optional<PagesaPerItinerar> verifikoPagesen(PagesaPerItinerarId id) {
        return rep.findById(id);
    }

    public List<PagesaPerItinerar> merrSipasTuristi(int turistId) {
        return rep.findByTurist_TuristId(turistId);
    }

    public List<PagesaPerItinerar> merrSipasItinerarit(int itinerarId) {
        return rep.findByItinerar_ItinerarId(itinerarId);
    }
}
