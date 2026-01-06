package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.Itinerar;
import com.viaAlbania.viaAlbania.entity.Lokacion;
import com.viaAlbania.viaAlbania.entity.PikaPerItinerar;
import com.viaAlbania.viaAlbania.entity.PikaPerItinerarId;
import com.viaAlbania.viaAlbania.repository.PikaPerItinerarRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PikaPerItinerarService {

    @Autowired
    private PikaPerItinerarRep rep;

    public PikaPerItinerar shtoPikeNeItinerar(Itinerar itinerar, Lokacion lokacion, Integer rendi) {
        PikaPerItinerar pika = new PikaPerItinerar(itinerar, lokacion, rendi, false, null);
        return rep.save(pika);
    }

    public PikaPerItinerar ndryshoRend(Itinerar itinerar, Lokacion lokacion, Integer rendiRi) {
        PikaPerItinerarId id = new PikaPerItinerarId(itinerar.getItinerarId(), lokacion.getLokacionId());
        Optional<PikaPerItinerar> pikaOpt = rep.findById(id);
        if (pikaOpt.isPresent()) {
            PikaPerItinerar pika = pikaOpt.get();
            pika.setRendi(rendiRi);
            return rep.save(pika);
        }
        return null;
    }

    public PikaPerItinerar bejCheckIn(Itinerar itinerar, Lokacion lokacion) {
        PikaPerItinerarId id = new PikaPerItinerarId(itinerar.getItinerarId(), lokacion.getLokacionId());
        Optional<PikaPerItinerar> pikaOpt = rep.findById(id);
        if (pikaOpt.isPresent()) {
            PikaPerItinerar pika = pikaOpt.get();
            pika.setCheckin(true);
            pika.setCheckinTime(LocalDateTime.now());
            return rep.save(pika);
        }
        return null;
    }

    public double llogaritDistancen(Lokacion l1, Lokacion l2) {
        final int R = 6371; // radius of Earth in km
        double latDistance = Math.toRadians(l2.getLatitude() - l1.getLatitude());
        double lonDistance = Math.toRadians(l2.getLongitude() - l1.getLongitude());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(l1.getLatitude())) * Math.cos(Math.toRadians(l2.getLatitude()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // distance in km
    }
}
