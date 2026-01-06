package com.viaAlbania.viaAlbania.repository;

import com.viaAlbania.viaAlbania.entity.PergjegjesLokal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PergjegjesLokalRep extends JpaRepository<PergjegjesLokal, Integer> {
    Optional<PergjegjesLokal> findByEmail(String email);
}
