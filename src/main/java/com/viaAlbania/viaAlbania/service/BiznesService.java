package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.Biznes;
import com.viaAlbania.viaAlbania.repository.BiznesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Service
public class BiznesService {

    @Autowired
    private BiznesRep biznesRep;

    public Biznes krijo(Biznes biznes) {
        biznes.setAktiv(true);
        biznes.setDataKrijimit(LocalDate.now());
        return biznesRep.save(biznes);
    }

    public Biznes perditesoTeDhenat(int id, Biznes updated) {
        Optional<Biznes> opt = biznesRep.findById(id);
        if (opt.isPresent()) {
            Biznes b = opt.get();
            b.setEmri(updated.getEmri());
            b.setPershkrimShtese(updated.getPershkrimShtese());
            b.setLatitude(updated.getLatitude());
            b.setLongitude(updated.getLongitude());
            b.setTipi(updated.getTipi());
            b.setAdresa(updated.getAdresa());
            b.setKategoria(updated.getKategoria());
            b.setPershkrimShtese(updated.getPershkrimShtese());
            return biznesRep.save(b);
        }
        return null;
    }

    public Biznes caktivizo(int id) {
        Optional<Biznes> opt = biznesRep.findById(id);
        if (opt.isPresent()) {
            Biznes b = opt.get();
            b.setAktiv(false);
            return biznesRep.save(b);
        }
        return null;
    }

    public Biznes vendosOraret(int id, String orari) {
        Optional<Biznes> opt = biznesRep.findById(id);
        if (opt.isPresent()) {
            Biznes b = opt.get();
            b.setOrari(orari);
            return biznesRep.save(b);
        }
        return null;
    }


    public Biznes perditesoCmimin(int id, Double cmimMesatar) {
        Optional<Biznes> opt = biznesRep.findById(id);
        if (opt.isPresent()) {
            Biznes b = opt.get();
            b.setCmimMesatar(cmimMesatar);
            return biznesRep.save(b);
        }
        return null;
    }

    public Biznes perditesoDisponueshmerine(int id, String disponueshmeri) {
        Optional<Biznes> opt = biznesRep.findById(id);
        if (opt.isPresent()) {
            Biznes b = opt.get();
            b.setDisponueshmeri(disponueshmeri);
            return biznesRep.save(b);
        }
        return null;
    }

    public List<Biznes> merrTeGjitha() {
        return biznesRep.findAll();
    }
}
