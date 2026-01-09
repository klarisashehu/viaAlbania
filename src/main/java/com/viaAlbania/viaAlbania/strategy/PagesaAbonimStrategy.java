package com.viaAlbania.viaAlbania.strategy;

import com.viaAlbania.viaAlbania.entity.Pagesa;
import org.springframework.stereotype.Component;

@Component("ABONIM")
public class PagesaAbonimStrategy implements PagesaStrategy {

    @Override
    public void proceso(Pagesa pagesa) {
        pagesa.setStatusi("Perfuduar");
    }

    @Override
    public String gjeneroFature(Pagesa p) {
        return "Fature Abonimi Mujor\n" +
                "ID Pagesa: " + p.getPagesaId() + "\n" +
                "Shuma: " + p.getShuma() + "\n" +
                "Statusi: " + p.getStatusi();
    }
}
