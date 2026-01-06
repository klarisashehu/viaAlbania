package com.viaAlbania.viaAlbania.repository;

import com.viaAlbania.viaAlbania.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRep extends JpaRepository<Feedback, Integer> {
    List<Feedback> findByItinerar_ItinerarId(int itinerarId);
    List<Feedback> findByTurist_TuristId(int turistId);
}
