package com.viaAlbania.viaAlbania.repository;

import com.viaAlbania.viaAlbania.entity.Pagesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagesaRep extends JpaRepository<Pagesa, Integer> {
}
