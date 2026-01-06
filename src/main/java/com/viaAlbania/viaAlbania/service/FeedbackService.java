package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.Feedback;
import com.viaAlbania.viaAlbania.repository.FeedbackRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRep rep;

    public Feedback shtoFeedback(Feedback feedback) {
        return rep.save(feedback);
    }

    public Optional<Feedback> shikoFeedback(int feedbackId) {
        return rep.findById(feedbackId);
    }

    public List<Feedback> shikoFeedbackPerItinerar(int itinerarId) {
        return rep.findByItinerar_ItinerarId(itinerarId);
    }

    public List<Feedback> shikoFeedbackPerTurist(int turistId) {
        return rep.findByTurist_TuristId(turistId);
    }
}
