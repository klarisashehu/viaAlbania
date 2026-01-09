package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.AbonimeBiznesi;
import com.viaAlbania.viaAlbania.service.AbonimeBiznesiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/abonimeBiznesi")
public class AbonimeBiznesiController {

    @Autowired
    private AbonimeBiznesiService service;

    @PostMapping("/ruaj")
    public AbonimeBiznesi ruaj(@RequestBody AbonimeBiznesi abonim) {
        return service.ruajAbonimin(abonim);
    }

    @PutMapping("/proceso")
    public AbonimeBiznesi procesoPages(@RequestParam int abonimiId) {
        return service.procesoPagesen(abonimiId);
    }

    @GetMapping("/fature")
    public String gjeneroFaturen(@RequestParam int abonimiId) {
        return service.gjeneroFaturen(abonimiId);
    }

    @PutMapping("/aktivizo")
    public AbonimeBiznesi aktivizoAbonimin(@RequestParam int abonimiId) {
        return service.aktivizoAbonimin(abonimiId);
    }

    @GetMapping("/merr")
    public Optional<AbonimeBiznesi> merrAbonimin(@RequestParam int abonimiId) {
        return service.merrAbonimin(abonimiId);
    }

    @GetMapping("/biznes/{biznesId}")
    public List<AbonimeBiznesi> merrAbonimeSipasBiznesit(@PathVariable int biznesId) {
        return service.merrAbonimeSipasBiznesit(biznesId);
    }
}
