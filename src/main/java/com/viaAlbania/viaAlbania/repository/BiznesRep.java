package com.viaAlbania.viaAlbania.repository;

import com.viaAlbania.viaAlbania.entity.Biznes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiznesRep extends JpaRepository<Biznes, Integer> {

    List<Biznes> findByKategoria(String kategoria);

    List<Biznes> findByPerdorues_PerdoresId(int perdoruesId);

    List<Biznes> findByAprovuarNga_AdminId(int adminId);
}
