package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.PikaTuristike;
import com.viaAlbania.viaAlbania.repository.PikaTuristikeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PikaTuristikeService {

    @Autowired
    private PikaTuristikeRep pikaTuristikeRep;

    // ========================
    // KRIJO
    // ========================
    public PikaTuristike krijo(PikaTuristike pika) {
        pika.setAktiv(true);
        pika.setDataKrijimit(LocalDate.now());
        return pikaTuristikeRep.save(pika);
    }

    // ========================
    // PERDITESO TE DHENAT
    // ========================
    public PikaTuristike perditesoTeDhenat(int id, PikaTuristike updated) {
        Optional<PikaTuristike> opt = pikaTuristikeRep.findById(id);
        if (opt.isPresent()) {
            PikaTuristike p = opt.get();
            p.setEmri(updated.getEmri());
            p.setPershkrimi(updated.getPershkrimi());
            p.setLatitude(updated.getLatitude());
            p.setLongitude(updated.getLongitude());
            p.setTipi(updated.getTipi());
            p.setOrari(updated.getOrari());
            p.setAdresa(updated.getAdresa());
            p.setKategoria(updated.getKategoria());
            p.setBashkia(updated.getBashkia());
            p.setPergjegjesLokal(updated.getPergjegjesLokal());
            return pikaTuristikeRep.save(p);
        }
        return null;
    }

    // ========================
    // CAKTIVIZO
    // ========================
    public PikaTuristike caktivizo(int id) {
        Optional<PikaTuristike> opt = pikaTuristikeRep.findById(id);
        if (opt.isPresent()) {
            PikaTuristike p = opt.get();
            p.setAktiv(false);
            return pikaTuristikeRep.save(p);
        }
        return null;
    }

    // ========================
    // VENDOS CMIM
    // ========================
    public PikaTuristike vendosCmim(int id, Double cmim) {
        Optional<PikaTuristike> opt = pikaTuristikeRep.findById(id);
        if (opt.isPresent()) {
            PikaTuristike p = opt.get();
            p.setCmimi(cmim);
            return pikaTuristikeRep.save(p);
        }
        return null;
    }

    // ========================
    // LISTO TE GJITHE
    // ========================
    public List<PikaTuristike> merrTeGjitha() {
        return pikaTuristikeRep.findAll();
    }
}
