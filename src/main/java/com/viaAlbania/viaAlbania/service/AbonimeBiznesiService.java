package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.AbonimeBiznesi;
import com.viaAlbania.viaAlbania.repository.AbonimeBiznesiRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbonimeBiznesiService {

    @Autowired
    private AbonimeBiznesiRep rep;

    @Autowired
    private PagesaService pagesaService;

    public AbonimeBiznesi ruajAbonimin(AbonimeBiznesi abonim) {
        return rep.save(abonim);
    }

    public AbonimeBiznesi procesoPagesen(int abonimiId) {
        Optional<AbonimeBiznesi> opt = rep.findById(abonimiId);
        if (opt.isPresent()) {
            AbonimeBiznesi abonim = opt.get();
            if (abonim.getPagesa() != null) {
                pagesaService.procesoPagesen(abonim.getPagesa().getPagesaId(), "ABONIM");
            }
            return rep.save(abonim);
        }
        return null;
    }

    public String gjeneroFaturen(int abonimiId) {
        Optional<AbonimeBiznesi> opt = rep.findById(abonimiId);
        if (opt.isPresent()) {
            AbonimeBiznesi abonim = opt.get();
            if (abonim.getPagesa() != null) {
                return pagesaService.gjeneroFaturen(abonim.getPagesa().getPagesaId(), "ABONIM");
            }
        }
        return "Abonimi nuk u gjet";
    }

    public AbonimeBiznesi aktivizoAbonimin(int abonimiId) {
        Optional<AbonimeBiznesi> opt = rep.findById(abonimiId);
        if (opt.isPresent()) {
            AbonimeBiznesi abonim = opt.get();
            abonim.setAktiv(1);
            return rep.save(abonim);
        }
        return null;
    }

    public Optional<AbonimeBiznesi> merrAbonimin(int abonimiId) {
        return rep.findById(abonimiId);
    }

    public List<AbonimeBiznesi> merrAbonimeSipasBiznesit(int biznesId) {
        return rep.findByBiznes_BiznesId(biznesId);
    }
}
