package com.viaAlbania.viaAlbania.repository;

import com.viaAlbania.viaAlbania.entity.LinkJashtem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkJashtemRep extends JpaRepository<LinkJashtem, Integer> {
    List<LinkJashtem> findByBiznes_BiznesId(int biznesId);
}

