package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.Turist;
import com.viaAlbania.viaAlbania.repository.TuristRep;
import com.viaAlbania.viaAlbania.entity.Perdorues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TuristService {

    @Autowired
    private TuristRep turistRep;

    @Autowired
    private PerdoruesService perdoruesService; // delegate login/signin/updateData

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Optional<Turist> regjitrohu(String email, String plainPassword) {
        Optional<Perdorues> userOpt = perdoruesService.regjistrohu(email, plainPassword);

        if (userOpt.isPresent() && userOpt.get() instanceof Turist) {
            return Optional.of((Turist) userOpt.get());
        }
        return Optional.empty();
    }

    public Turist identifikohu(Turist newTurist) {
        Perdorues saved = perdoruesService.identifikohu(newTurist);
        return (Turist) saved;
    }

    public Turist perditesoTeDhena(Turist updatedTurist) {
        Perdorues saved = perdoruesService.perditesoTeDhena(updatedTurist.getPerdoruesId(), updatedTurist);
        return (Turist) saved;
    }

    public void selektoPreferenca(Turist turist, String preferences) {
        turist.setPreferencat(preferences);
        turistRep.save(turist);
    }

    public void zgjidhBuxhet(Turist turist, Double min, Double max) {
        turist.setBuxhetiMin(min);
        turist.setBuxhetiMax(max);
        turistRep.save(turist);
    }

    public String gjeneroRaport(Turist turist) {
        return "Raport\n Emri: " + turist.getEmer() + "\nPreferencat=" + turist.getPreferencat();
    }
}
