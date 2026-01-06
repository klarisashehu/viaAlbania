package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.Pagesa;
import com.viaAlbania.viaAlbania.repository.PagesaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PagesaService {

    @Autowired
    private PagesaRep pagesaRep;

    public Pagesa ruajPagesen(Pagesa pagesa) {
        pagesa.setDataPageses(LocalDate.now());
        pagesa.setStatusi("Nuk perfunduar");
        return pagesaRep.save(pagesa);
    }

    public Pagesa procesoPagesen(int pagesaId, String statusi) {
        Optional<Pagesa> opt = pagesaRep.findById(pagesaId);
        if (opt.isPresent()) {
            Pagesa pagesa = opt.get();
            pagesa.setStatusi(statusi);
            return pagesaRep.save(pagesa);
        }
        return null;
    }

    public String gjeneroFaturen(int pagesaId) {
        Optional<Pagesa> opt = pagesaRep.findById(pagesaId);
        if (opt.isPresent()) {
            Pagesa p = opt.get();
            return "Fature Pagesa\n" +
                    "ID Pagesa: " + p.getPagesaId() + "\n" +
                    "Shuma: " + p.getShuma() + "\n" +
                    "Data: " + p.getDataPageses() + "\n" +
                    "Statusi: " + p.getStatusi() + "\n" +
                    "Paypal Token: " + p.getPaypalTokenId();
        }
        return "Pagesa nuk u gjet";
    }

    public List<Pagesa> merrTeGjitha() {
        return pagesaRep.findAll();
    }

    public Optional<Pagesa> merrMeId(int id) {
        return pagesaRep.findById(id);
    }
}
