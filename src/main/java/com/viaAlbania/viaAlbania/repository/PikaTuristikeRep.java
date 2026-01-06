package com.viaAlbania.viaAlbania.repository;

import com.viaAlbania.viaAlbania.entity.PikaTuristike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PikaTuristikeRep extends JpaRepository<PikaTuristike, Integer> {

    List<PikaTuristike> findByKategoria(String kategoria);

    List<PikaTuristike> findByBashkia(String bashkia);
}
