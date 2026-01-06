package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.Lokacion;
import com.viaAlbania.viaAlbania.entity.PikaPerItinerar;
import com.viaAlbania.viaAlbania.service.PikaPerItinerarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itinerar/pika")
public class PikaPerItinerarController {

    @Autowired
    private PikaPerItinerarService service;

    @PostMapping("/shto")
    public PikaPerItinerar shtoPike(@RequestBody PikaPerItinerar pika) {
        return service.shtoPikeNeItinerar(pika.getItinerar(), pika.getLokacion(), pika.getRendi());
    }

    @PutMapping("/ndryshoRend")
    public PikaPerItinerar ndryshoRend(@RequestBody PikaPerItinerar pika) {
        return service.ndryshoRend(pika.getItinerar(), pika.getLokacion(), pika.getRendi());
    }

    @PutMapping("/checkin")
    public PikaPerItinerar bejCheckIn(@RequestBody PikaPerItinerar pika) {
        return service.bejCheckIn(pika.getItinerar(), pika.getLokacion());
    }

    @GetMapping("/llogaritDistancen")
    public double llogaritDistancen(@RequestBody Lokacion l1, @RequestBody Lokacion l2) {
        return service.llogaritDistancen(l1, l2);
    }
}

