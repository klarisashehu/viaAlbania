package com.viaAlbania.viaAlbania.repository;

import com.viaAlbania.viaAlbania.entity.AbonimeBiznesi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AbonimeBiznesiRep extends JpaRepository<AbonimeBiznesi, Integer> {

    List<AbonimeBiznesi> findByBiznes_BiznesId(int biznesId);
    List<AbonimeBiznesi> findByPagesa_PagesaId(int pagesaId);

}
