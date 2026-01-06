package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.Perdorues;
import com.viaAlbania.viaAlbania.service.PerdoruesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/perdorues")
public class PerdoruesController {

    @Autowired
    private PerdoruesService perdoruesService;

    @PostMapping("/login")
    public Optional<Perdorues> login(@RequestParam String email,
                                     @RequestParam String fjalkalimi) {
        return perdoruesService.regjistrohu(email, fjalkalimi);
    }

    @PostMapping("/register")
    public Perdorues register(@RequestBody Perdorues perdorues) {
        return perdoruesService.identifikohu(perdorues);
    }

    @PutMapping("/perditeso/{id}")
    public Perdorues perditeso(@PathVariable int id,
                               @RequestBody Perdorues perdorues) {
        return perdoruesService.perditesoTeDhena(id, perdorues);
    }
}
