package com.viaAlbania.viaAlbania.repository;

import com.viaAlbania.viaAlbania.entity.Itinerar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItinerarRep extends JpaRepository<Itinerar, Integer> {
    List<Itinerar> findByTurist_TuristId(int turistId);
}
