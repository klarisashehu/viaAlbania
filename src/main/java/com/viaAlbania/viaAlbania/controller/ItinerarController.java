package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.Itinerar;
import com.viaAlbania.viaAlbania.entity.Turist;
import com.viaAlbania.viaAlbania.service.ItinerarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itinerar")
public class ItinerarController {

    @Autowired
    private ItinerarService itinerarService;

    @PostMapping("/ruaj")
    public Itinerar ruajItinerar(@RequestBody Itinerar itinerar) {
        return itinerarService.ruajItinerar(itinerar);
    }

    @PostMapping("/gjenero")
    public Itinerar gjeneroItinerar(@RequestParam int turistId,
                                    @RequestParam String start,
                                    @RequestParam String end,
                                    @RequestParam Double kostoTotale,
                                    @RequestParam String raport) {
        Turist turist = new Turist();
        turist.setPerdoruesId(turistId);
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return itinerarService.gjeneroItinerar(turist, startDate, endDate, kostoTotale, raport);
    }

    @GetMapping
    public List<Itinerar> merrTeGjitha() {
        return itinerarService.merrTeGjitha();
    }

    @GetMapping("/turist/{turistId}")
    public List<Itinerar> merrSipasTuristi(@PathVariable int turistId) {
        return itinerarService.merrSipasTuristi(turistId);
    }

    @GetMapping("/{id}")
    public Optional<Itinerar> merrMeId(@PathVariable int id) {
        return itinerarService.merrMeId(id);
    }
}
