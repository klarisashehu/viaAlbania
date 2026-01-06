package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.PergjegjesLokal;
import com.viaAlbania.viaAlbania.entity.PikaTuristike;
import com.viaAlbania.viaAlbania.repository.PergjegjesLokalRep;
import com.viaAlbania.viaAlbania.repository.PikaTuristikeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PergjegjesLokalService {

    @Autowired
    private PergjegjesLokalRep lokalRep;

    @Autowired
    private PikaTuristikeRep pikeRep;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Optional<PergjegjesLokal> regjistrohu(String email, String plainPassword) {
        Optional<PergjegjesLokal> userOpt = lokalRep.findByEmail(email);
        if (userOpt.isPresent() && passwordEncoder.matches(plainPassword, userOpt.get().getFjalkalimi())) {
            return userOpt;
        }
        return Optional.empty();
    }

    public PergjegjesLokal identifikohu(PergjegjesLokal newLokal) {
        newLokal.setFjalkalimi(passwordEncoder.encode(newLokal.getFjalkalimi()));
        return lokalRep.save(newLokal);
    }

    public PikaTuristike shtoPikeTuristike(PikaTuristike pika) {
        return pikeRep.save(pika);
    }

    public PikaTuristike perditesoPikeTuristike(int pikaId, PikaTuristike updatedPika) {
        Optional<PikaTuristike> pikaOpt = pikeRep.findById(pikaId);
        if (pikaOpt.isPresent()) {
            PikaTuristike pika = pikaOpt.get();
            pika.setEmri(updatedPika.getEmri());
            pika.setPershkrimi(updatedPika.getPershkrimi());
            pika.setLatitude(updatedPika.getLatitude());
            pika.setLongitude(updatedPika.getLongitude());
            pika.setTipi(updatedPika.getTipi());
            pika.setOrari(updatedPika.getOrari());
            pika.setAdresa(updatedPika.getAdresa());
            pika.setCmimi(updatedPika.getCmimi());
            pika.setKategoria(updatedPika.getKategoria());
            pika.setBashkia(updatedPika.getBashkia());
            pika.setPergjegjesLokal(updatedPika.getPergjegjesLokal());
            return pikeRep.save(pika);
        }
        return null;
    }

    public boolean fshiPikeTuristike(int pikaId) {
        if (pikeRep.existsById(pikaId)) {
            pikeRep.deleteById(pikaId);
            return true;
        }
        return false;
    }
}

