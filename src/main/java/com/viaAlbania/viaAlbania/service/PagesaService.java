package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.Pagesa;
import com.viaAlbania.viaAlbania.repository.PagesaRep;
import com.viaAlbania.viaAlbania.strategy.PagesaStrategy;
import com.viaAlbania.viaAlbania.strategy.PagesaStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PagesaService {

    @Autowired
    private PagesaRep pagesaRep;

    @Autowired
    private PagesaStrategyFactory strategyFactory;

    public Pagesa ruajPagesen(Pagesa pagesa) {
        pagesa.setDataPageses(LocalDate.now());
        pagesa.setStatusi("Nuk perfunduar");
        return pagesaRep.save(pagesa);
    }

    public Pagesa procesoPagesen(int pagesaId, String tipiPageses) {
        Optional<Pagesa> opt = pagesaRep.findById(pagesaId);
        if (opt.isPresent()) {
            Pagesa pagesa = opt.get();

            PagesaStrategy strategy = strategyFactory.merrStrategjine(tipiPageses);
            strategy.proceso(pagesa);

            return pagesaRep.save(pagesa);
        }
        return null;
    }

    public String gjeneroFaturen(int pagesaId, String tipiPageses) {
        Optional<Pagesa> opt = pagesaRep.findById(pagesaId);
        if (opt.isPresent()) {
            Pagesa p = opt.get();
            PagesaStrategy strategy = strategyFactory.merrStrategjine(tipiPageses);
            return strategy.gjeneroFature(p);
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
