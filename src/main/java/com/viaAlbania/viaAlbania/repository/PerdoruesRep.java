package com.viaAlbania.viaAlbania.repository;

import com.viaAlbania.viaAlbania.entity.Perdorues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PerdoruesRep extends JpaRepository<Perdorues, Integer> {
    Optional<Perdorues> findByEmail(String email);
}
