package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.PikaTuristike;
import com.viaAlbania.viaAlbania.service.PikaTuristikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pikatTuristike")
public class PikaTuristikeController {

    @Autowired
    private PikaTuristikeService pikaTuristikeService;


    @PostMapping("/krijo")
    public PikaTuristike krijo(@RequestBody PikaTuristike pika) {
        return pikaTuristikeService.krijo(pika);
    }

    @PutMapping("/perditeso/{id}")
    public PikaTuristike perditesoTeDhenat(@PathVariable int id,
                                           @RequestBody PikaTuristike pika) {
        return pikaTuristikeService.perditesoTeDhenat(id, pika);
    }


    @PutMapping("/caktivizo/{id}")
    public PikaTuristike caktivizo(@PathVariable int id) {
        return pikaTuristikeService.caktivizo(id);
    }

    @PutMapping("/cmim/{id}")
    public PikaTuristike vendosCmim(@PathVariable int id,
                                    @RequestParam Double cmim) {
        return pikaTuristikeService.vendosCmim(id, cmim);
    }


    @GetMapping
    public List<PikaTuristike> merrTeGjitha() {
        return pikaTuristikeService.merrTeGjitha();
    }
}
