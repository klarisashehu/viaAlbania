package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.PagesaPerItinerar;
import com.viaAlbania.viaAlbania.entity.PagesaPerItinerarId;
import com.viaAlbania.viaAlbania.service.PagesaPerItinerarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagesaPerItinerar")
public class PagesaPerItinerarController {

    @Autowired
    private PagesaPerItinerarService service;

    @PostMapping("/ruaj")
    public PagesaPerItinerar ruaj(@RequestBody PagesaPerItinerar ppi) {
        return service.ruaj(ppi);
    }

    @PutMapping("/proceso")
    public PagesaPerItinerar procesoPages(@RequestParam int pagesaId,
                                          @RequestParam int itinerarId,
                                          @RequestParam int turistId,
                                          @RequestParam String statusi) {
        PagesaPerItinerarId id = new PagesaPerItinerarId(itinerarId, turistId);
        return service.procesoPages(id, statusi);
    }

    @GetMapping("/fature")
    public String gjeneroFaturen(@RequestParam int pagesaId,
                                 @RequestParam int itinerarId,
                                 @RequestParam int turistId) {
        PagesaPerItinerarId id = new PagesaPerItinerarId(itinerarId, turistId);
        return service.gjeneroFaturen(id);
    }

    @PutMapping("/zgjidhLloji")
    public PagesaPerItinerar zgjidhLlojinESherbimit(@RequestParam int pagesaId,
                                                    @RequestParam int itinerarId,
                                                    @RequestParam int turistId,
                                                    @RequestParam String lloji) {
        PagesaPerItinerarId id = new PagesaPerItinerarId(itinerarId, turistId);
        return service.zgjidhLlojinESherbimit(id, lloji);
    }

    @GetMapping("/verifiko")
    public Optional<PagesaPerItinerar> verifikoPagesen(@RequestParam int pagesaId,
                                                       @RequestParam int itinerarId,
                                                       @RequestParam int turistId) {
        PagesaPerItinerarId id = new PagesaPerItinerarId(itinerarId, turistId);
        return service.verifikoPagesen(id);
    }

    @GetMapping("/turist/{turistId}")
    public List<PagesaPerItinerar> merrSipasTuristi(@PathVariable int turistId) {
        return service.merrSipasTuristi(turistId);
    }

    @GetMapping("/itinerar/{itinerarId}")
    public List<PagesaPerItinerar> merrSipasItinerarit(@PathVariable int itinerarId) {
        return service.merrSipasItinerarit(itinerarId);
    }
}
