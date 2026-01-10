package com.viaAlbania.viaAlbania;

import com.viaAlbania.viaAlbania.entity.Feedback;
import com.viaAlbania.viaAlbania.repository.FeedbackRep;
import com.viaAlbania.viaAlbania.service.FeedbackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FeedbackServiceTest {

    @Mock
    private FeedbackRep rep;

    @InjectMocks
    private FeedbackService feedbackService;

    private Feedback feedback;

    @BeforeEach
    void setUp() {
        feedback = new Feedback();
        feedback.setFeedbackId(1);
        feedback.setKoment("Shume mire");
    }

    @Test
    void shtoFeedback_success() {
        when(rep.save(any(Feedback.class))).thenAnswer(i -> i.getArgument(0));

        Feedback result = feedbackService.shtoFeedback(feedback);

        assertNotNull(result);
        assertEquals("Shume mire", result.getKoment());
    }

    @Test
    void shikoFeedback_success() {
        when(rep.findById(1)).thenReturn(Optional.of(feedback));

        Optional<Feedback> result = feedbackService.shikoFeedback(1);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getFeedbackId());
    }

    @Test
    void shikoFeedback_notFound() {
        when(rep.findById(99)).thenReturn(Optional.empty());

        Optional<Feedback> result = feedbackService.shikoFeedback(99);

        assertFalse(result.isPresent());
    }

    @Test
    void shikoFeedbackPerItinerar_success() {
        List<Feedback> list = new ArrayList<>();
        list.add(feedback);

        when(rep.findByItinerar_ItinerarId(1)).thenReturn(list);

        List<Feedback> result = feedbackService.shikoFeedbackPerItinerar(1);

        assertEquals(1, result.size());
        assertEquals("Shume mire", result.get(0).getKoment());
    }

    @Test
    void shikoFeedbackPerTurist_success() {
        List<Feedback> list = new ArrayList<>();
        list.add(feedback);

        when(rep.findByTurist_TuristId(1)).thenReturn(list);

        List<Feedback> result = feedbackService.shikoFeedbackPerTurist(1);

        assertEquals(1, result.size());
        assertEquals("Shume mire", result.get(0).getKoment());
    }
}