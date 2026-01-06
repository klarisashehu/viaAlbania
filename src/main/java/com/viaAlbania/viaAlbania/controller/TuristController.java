package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.Turist;
import com.viaAlbania.viaAlbania.service.TuristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/turist")
public class TuristController {

    @Autowired
    private TuristService turistService;

    @PostMapping("/login")
    public Optional<Turist> login(@RequestParam String email,
                                  @RequestParam String fjalkalimi) {
        return turistService.regjitrohu(email, fjalkalimi);
    }

    @PostMapping("/register")
    public Turist register(@RequestBody Turist turist) {
        return turistService.identifikohu(turist);
    }


    @PutMapping("/perditeso")
    public Turist perditeso(@RequestBody Turist turist) {
        return turistService.perditesoTeDhena(turist);
    }

    @PutMapping("/preferenca")
    public String selektoPreferenca(@RequestParam int turistId,
                                    @RequestParam String preferenca) {
        Turist turist = new Turist();
        turist.setPerdoruesId(turistId);
        turistService.selektoPreferenca(turist, preferenca);
        return "Preferencat u ruajtën me sukses";
    }


    @PutMapping("/buxhet")
    public String zgjidhBuxhet(@RequestParam int turistId,
                               @RequestParam Double min,
                               @RequestParam Double max) {
        Turist turist = new Turist();
        turist.setPerdoruesId(turistId);
        turistService.zgjidhBuxhet(turist, min, max);
        return "Buxheti u ruajt me sukses";
    }


    @GetMapping("/raport/{turistId}")
    public String gjeneroRaport(@PathVariable int turistId) {
        Turist turist = new Turist();
        turist.setPerdoruesId(turistId);
        return turistService.gjeneroRaport(turist);
    }
}
