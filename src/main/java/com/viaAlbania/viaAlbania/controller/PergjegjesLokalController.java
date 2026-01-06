package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.PergjegjesLokal;
import com.viaAlbania.viaAlbania.entity.PikaTuristike;
import com.viaAlbania.viaAlbania.service.PergjegjesLokalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lokal")
public class PergjegjesLokalController {

    @Autowired
    private PergjegjesLokalService service;

    @PostMapping("/regjistrohu")
    public PergjegjesLokal regjistrohu(@RequestBody PergjegjesLokal lokal) {
        return service.identifikohu(lokal);
    }

    @PostMapping("/login")
    public Optional<PergjegjesLokal> identifikohu(@RequestParam String email, @RequestParam String password) {
        return service.regjistrohu(email, password);
    }

    @PostMapping("/pike/shto")
    public PikaTuristike shtoPikeTuristike(@RequestBody PikaTuristike pika) {
        return service.shtoPikeTuristike(pika);
    }

    @PutMapping("/pike/perditeso/{pikaId}")
    public PikaTuristike perditesoPikeTuristike(@PathVariable int pikaId, @RequestBody PikaTuristike updatedPika) {
        return service.perditesoPikeTuristike(pikaId, updatedPika);
    }

    @DeleteMapping("/pike/fshi/{pikaId}")
    public boolean fshiPikeTuristike(@PathVariable int pikaId) {
        return service.fshiPikeTuristike(pikaId);
    }
}
