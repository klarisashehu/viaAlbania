package com.viaAlbania.viaAlbania.repository;

import com.viaAlbania.viaAlbania.entity.Turist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TuristRep extends JpaRepository<Turist, Integer> {
    Optional<Turist> findByEmail(String email);
}
