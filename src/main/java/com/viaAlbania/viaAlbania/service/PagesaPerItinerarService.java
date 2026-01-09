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

    @Autowired
    private PagesaService pagesaService;

    public PagesaPerItinerar ruaj(PagesaPerItinerar ppi) {
        return rep.save(ppi);
    }

    public PagesaPerItinerar procesoPages(PagesaPerItinerarId id) {
        Optional<PagesaPerItinerar> opt = rep.findById(id);
        if (opt.isPresent()) {
            PagesaPerItinerar ppi = opt.get();
            pagesaService.procesoPagesen(ppi.getPagesa().getPagesaId(), "ITINERAR");
            return rep.save(ppi);
        }
        return null;
    }

    public String gjeneroFaturen(PagesaPerItinerarId id) {
        Optional<PagesaPerItinerar> opt = rep.findById(id);
        if (opt.isPresent()) {
            PagesaPerItinerar ppi = opt.get();
            return pagesaService.gjeneroFaturen(ppi.getPagesa().getPagesaId(), "ITINERAR");
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
