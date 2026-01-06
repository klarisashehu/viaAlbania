package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.AbonimeBiznesi;
import com.viaAlbania.viaAlbania.service.AbonimeBiznesiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/abonime")
public class AbonimeBiznesiController {

    @Autowired
    private AbonimeBiznesiService service;

    @PostMapping("/ruaj")
    public AbonimeBiznesi ruajAbonimin(@RequestBody AbonimeBiznesi abonim) {
        return service.ruajAbonimin(abonim);
    }

    @PutMapping("/proceso")
    public AbonimeBiznesi procesoPagesen(@RequestParam int abonimiId,
                                         @RequestParam String statusi) {
        return service.procesoPagesen(abonimiId, statusi);
    }

    @GetMapping("/fature/{abonimiId}")
    public String gjeneroFaturen(@PathVariable int abonimiId) {
        return service.gjeneroFaturen(abonimiId);
    }

    @PutMapping("/aktivizo/{abonimiId}")
    public AbonimeBiznesi aktivizoAbonimin(@PathVariable int abonimiId) {
        return service.aktivizoAbonimin(abonimiId);
    }

    @GetMapping("/{abonimiId}")
    public Optional<AbonimeBiznesi> merrAbonimin(@PathVariable int abonimiId) {
        return service.merrAbonimin(abonimiId);
    }
}
