package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.Feedback;
import com.viaAlbania.viaAlbania.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @PostMapping("/shto")
    public Feedback shtoFeedback(@RequestBody Feedback feedback) {
        return service.shtoFeedback(feedback);
    }

    @GetMapping("/{feedbackId}")
    public Optional<Feedback> shikoFeedback(@PathVariable int feedbackId) {
        return service.shikoFeedback(feedbackId);
    }

    @GetMapping("/itinerar/{itinerarId}")
    public List<Feedback> shikoFeedbackPerItinerar(@PathVariable int itinerarId) {
        return service.shikoFeedbackPerItinerar(itinerarId);
    }

    @GetMapping("/turist/{turistId}")
    public List<Feedback> shikoFeedbackPerTurist(@PathVariable int turistId) {
        return service.shikoFeedbackPerTurist(turistId);
    }
}
