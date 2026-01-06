package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.LinkJashtem;
import com.viaAlbania.viaAlbania.repository.LinkJashtemRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkJashtemService {

    @Autowired
    private LinkJashtemRep linkJashtemRep;

    public LinkJashtem shtoLink(LinkJashtem link) {
        return linkJashtemRep.save(link);
    }

    public LinkJashtem perditesoLink(int id, LinkJashtem updated) {
        Optional<LinkJashtem> opt = linkJashtemRep.findById(id);
        if (opt.isPresent()) {
            LinkJashtem l = opt.get();
            l.setTipi(updated.getTipi());
            l.setLink(updated.getLink());
            l.setBiznes(updated.getBiznes());
            return linkJashtemRep.save(l);
        }
        return null;
    }

    public boolean fshiLink(int id) {
        Optional<LinkJashtem> opt = linkJashtemRep.findById(id);
        if (opt.isPresent()) {
            linkJashtemRep.deleteById(id);
            return true;
        }
        return false;
    }

    public List<LinkJashtem> merrTeGjithaSipasBiznesit(int biznesId) {
        return linkJashtemRep.findByBiznes_BiznesId(biznesId);
    }

    public Optional<LinkJashtem> merrMeId(int id) {
        return linkJashtemRep.findById(id);
    }
}
