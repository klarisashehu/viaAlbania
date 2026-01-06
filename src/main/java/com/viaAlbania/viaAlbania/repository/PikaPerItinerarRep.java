package com.viaAlbania.viaAlbania.repository;

import com.viaAlbania.viaAlbania.entity.PikaPerItinerar;
import com.viaAlbania.viaAlbania.entity.PikaPerItinerarId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PikaPerItinerarRep extends JpaRepository<PikaPerItinerar, PikaPerItinerarId> {
    List<PikaPerItinerar> findByItinerar_ItinerarIdOrderByRendiAsc(int itinerarId);
}
