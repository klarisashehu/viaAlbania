package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.LinkJashtem;
import com.viaAlbania.viaAlbania.service.LinkJashtemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/linkJashtem")
public class LinkJashtemController {

    @Autowired
    private LinkJashtemService linkJashtemService;

    @PostMapping("/shto")
    public LinkJashtem shtoLink(@RequestBody LinkJashtem link) {
        return linkJashtemService.shtoLink(link);
    }

    @PutMapping("/perditeso/{id}")
    public LinkJashtem perditesoLink(@PathVariable int id, @RequestBody LinkJashtem link) {
        return linkJashtemService.perditesoLink(id, link);
    }

    @DeleteMapping("/fshi/{id}")
    public boolean fshiLink(@PathVariable int id) {
        return linkJashtemService.fshiLink(id);
    }

    @GetMapping("/biznes/{biznesId}")
    public List<LinkJashtem> merrTeGjithaSipasBiznesit(@PathVariable int biznesId) {
        return linkJashtemService.merrTeGjithaSipasBiznesit(biznesId);
    }

    @GetMapping("/{id}")
    public Optional<LinkJashtem> merrMeId(@PathVariable int id) {
        return linkJashtemService.merrMeId(id);
    }
}
