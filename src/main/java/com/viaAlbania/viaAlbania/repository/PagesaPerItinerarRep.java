package com.viaAlbania.viaAlbania.repository;

import com.viaAlbania.viaAlbania.entity.PagesaPerItinerar;
import com.viaAlbania.viaAlbania.entity.PagesaPerItinerarId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagesaPerItinerarRep extends JpaRepository<PagesaPerItinerar, PagesaPerItinerarId> {
    List<PagesaPerItinerar> findByTurist_TuristId(int turistId);
    List<PagesaPerItinerar> findByItinerar_ItinerarId(int itinerarId);
}
