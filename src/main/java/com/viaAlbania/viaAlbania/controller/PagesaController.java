package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.Pagesa;
import com.viaAlbania.viaAlbania.service.PagesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagesa")
public class PagesaController {

    @Autowired
    private PagesaService pagesaService;

    @PostMapping("/ruaj")
    public Pagesa ruajPagesen(@RequestBody Pagesa pagesa) {
        return pagesaService.ruajPagesen(pagesa);
    }

    @PutMapping("/proceso/{id}")
    public Pagesa procesoPagesen(@PathVariable int id,
                                 @RequestParam String statusi) {
        return pagesaService.procesoPagesen(id, statusi);
    }

    @GetMapping("/fature/{id}")
    public String gjeneroFaturen(@PathVariable int id) {
        return pagesaService.gjeneroFaturen(id);
    }

    @GetMapping
    public List<Pagesa> merrTeGjitha() {
        return pagesaService.merrTeGjitha();
    }

    @GetMapping("/{id}")
    public Optional<Pagesa> merrMeId(@PathVariable int id) {
        return pagesaService.merrMeId(id);
    }
}
