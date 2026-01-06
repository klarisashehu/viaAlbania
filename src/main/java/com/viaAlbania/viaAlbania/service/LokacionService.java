package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.Lokacion;
import com.viaAlbania.viaAlbania.repository.LokacionRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LokacionService {

    @Autowired
    private LokacionRep lokacionRep;


    public Lokacion krijo(Lokacion lokacion) {
        lokacion.setAktiv(true);
        return lokacionRep.save(lokacion);
    }


    public Lokacion perditesoTeDhenat(int id, Lokacion updated) {
        Optional<Lokacion> opt = lokacionRep.findById(id);
        if (opt.isPresent()) {
            Lokacion l = opt.get();
            l.setEmri(updated.getEmri());
            l.setPershkrimi(updated.getPershkrimi());
            l.setLatitude(updated.getLatitude());
            l.setLongitude(updated.getLongitude());
            l.setTipi(updated.getTipi());
            l.setOrari(updated.getOrari());
            l.setAdresa(updated.getAdresa());
            return lokacionRep.save(l);
        }
        return null;
    }
    public Lokacion caktivizo(int id) {
        Optional<Lokacion> opt = lokacionRep.findById(id);
        if (opt.isPresent()) {
            Lokacion l = opt.get();
            l.setAktiv(false);
            return lokacionRep.save(l);
        }
        return null;
    }
}