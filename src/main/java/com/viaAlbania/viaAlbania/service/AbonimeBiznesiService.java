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

    public AbonimeBiznesi ruajAbonimin(AbonimeBiznesi abonim) {
        return rep.save(abonim);
    }

    public AbonimeBiznesi procesoPagesen(int abonimiId, String statusi) {
        Optional<AbonimeBiznesi> opt = rep.findById(abonimiId);
        if (opt.isPresent()) {
            AbonimeBiznesi abonim = opt.get();
            if (abonim.getPagesa() != null) {
                abonim.getPagesa().setStatusi(statusi);
            }
            return rep.save(abonim);
        }
        return null;
    }

    public String gjeneroFaturen(int abonimiId) {
        Optional<AbonimeBiznesi> opt = rep.findById(abonimiId);
        if (opt.isPresent()) {
            AbonimeBiznesi abonim = opt.get();
            return "Fature Abonimi Biznesi\n" +
                    "Abonimi ID: " + abonim.getAbonimiId() + "\n" +
                    "Biznes: " + (abonim.getBiznes() != null ? abonim.getBiznes().getEmri() : "N/A") + "\n" +
                    "Pagesa ID: " + (abonim.getPagesa() != null ? abonim.getPagesa().getPagesaId() : "N/A") + "\n" +
                    "Shuma: " + (abonim.getPagesa() != null ? abonim.getPagesa().getShuma() : "N/A") + "\n" +
                    "Statusi: " + (abonim.getPagesa() != null ? abonim.getPagesa().getStatusi() : "N/A") + "\n" +
                    "Muaji: " + abonim.getMuaji() + "\n" +
                    "Aktiv: " + abonim.getAktiv();
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

