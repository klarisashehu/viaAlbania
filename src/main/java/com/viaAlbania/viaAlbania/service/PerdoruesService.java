package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.Perdorues;
import com.viaAlbania.viaAlbania.repository.PerdoruesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PerdoruesService {

    @Autowired
    private PerdoruesRep perdoruesRep;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Optional<Perdorues> regjistrohu(String email, String plainPassword) {
        Optional<Perdorues> userOpt = perdoruesRep.findByEmail(email);
        if (userOpt.isPresent() && passwordEncoder.matches(plainPassword, userOpt.get().getFjalkalimi())) {
            return userOpt;
        }
        return Optional.empty();
    }

    public Perdorues identifikohu(Perdorues newUser) {
        // hash password
        newUser.setFjalkalimi(passwordEncoder.encode(newUser.getFjalkalimi()));
        newUser.setDataKrijimit(LocalDate.now());
        return perdoruesRep.save(newUser);
    }

    public Perdorues perditesoTeDhena(int userId, Perdorues updatedUser) {
        Optional<Perdorues> userOpt = perdoruesRep.findById(userId);
        if (userOpt.isPresent()) {
            Perdorues user = userOpt.get();
            user.setEmer(updatedUser.getEmer());
            user.setMbiemer(updatedUser.getMbiemer());
            user.setEmail(updatedUser.getEmail());

            if (updatedUser.getFjalkalimi() != null && !updatedUser.getFjalkalimi().isEmpty()) {
                user.setFjalkalimi(passwordEncoder.encode(updatedUser.getFjalkalimi()));
            }
            return perdoruesRep.save(user);
        }
        return null;
    }
}
