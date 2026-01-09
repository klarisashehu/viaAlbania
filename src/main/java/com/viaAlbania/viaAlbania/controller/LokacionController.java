package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.Lokacion;
import com.viaAlbania.viaAlbania.service.LokacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lokacion")
public class LokacionController {

    @Autowired
    private LokacionService lokacionService;

    @PostMapping("/krijo")
    public Lokacion krijo(@RequestBody Lokacion lokacion) {
        return lokacionService.krijo(lokacion);
    }

    @PutMapping("/perditeso/{id}")
    public Lokacion perditeso(@PathVariable int id,
                              @RequestBody Lokacion lokacion) {
        return lokacionService.perditesoTeDhenat(id, lokacion);
    }

    @PutMapping("/caktivizo/{id}")
    public Lokacion caktivizo(@PathVariable int id) {
        return lokacionService.caktivizo(id);
    }
}
