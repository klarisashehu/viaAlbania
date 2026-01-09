package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.Biznes;
import com.viaAlbania.viaAlbania.service.BiznesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biznes")
public class BiznesController {

    @Autowired
    private BiznesService biznesService;

    @PostMapping("/krijo")
    public Biznes krijo(@RequestBody Biznes biznes) {
        return biznesService.krijo(biznes);
    }

    @PutMapping("/perditeso/{id}")
    public Biznes perditesoTeDhenat(@PathVariable int id,
                                    @RequestBody Biznes biznes) {
        return biznesService.perditesoTeDhenat(id, biznes);
    }

    @PutMapping("/caktivizo/{id}")
    public Biznes caktivizo(@PathVariable int id) {
        return biznesService.caktivizo(id);
    }


    @PutMapping("/orari/{id}")
    public Biznes vendosOraret(@PathVariable int id,
                               @RequestParam String orari) {
        return biznesService.vendosOraret(id, orari);
    }

    @PutMapping("/cmim/{id}")
    public Biznes perditesoCmimin(@PathVariable int id,
                                  @RequestParam Double cmim) {
        return biznesService.perditesoCmimin(id, cmim);
    }

    @PutMapping("/disponueshmeri/{id}")
    public Biznes perditesoDisponueshmerine(@PathVariable int id,
                                            @RequestParam String disponueshmeri) {
        return biznesService.perditesoDisponueshmerine(id, disponueshmeri);
    }

    @GetMapping
    public List<Biznes> merrTeGjitha() {
        return biznesService.merrTeGjitha();
    }
}
