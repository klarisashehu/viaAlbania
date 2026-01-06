package com.viaAlbania.viaAlbania.repository;

import com.viaAlbania.viaAlbania.entity.Lokacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LokacionRep extends JpaRepository<Lokacion, Integer> {

    List<Lokacion> findByTipi(String tipi);

    List<Lokacion> findByEmriContainingIgnoreCase(String emri);
}

