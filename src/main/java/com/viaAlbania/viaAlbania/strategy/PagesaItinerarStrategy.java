package com.viaAlbania.viaAlbania.strategy;

import com.viaAlbania.viaAlbania.entity.Pagesa;
import org.springframework.stereotype.Component;

@Component("ITINERAR")
public class PagesaItinerarStrategy implements PagesaStrategy {

    @Override
    public void proceso(Pagesa pagesa) {
        pagesa.setStatusi("Perfuduar");
    }

    @Override
    public String gjeneroFature(Pagesa p) {
        return "Fature Pagesa Itinerar\n" +
                "ID: " + p.getPagesaId() + "\n" +
                "Shuma: " + p.getShuma() + "\n" +
                "Statusi: " + p.getStatusi();
    }
}
