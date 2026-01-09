package com.viaAlbania.viaAlbania.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PagesaStrategyFactory {

    @Autowired
    private Map<String, PagesaStrategy> strategjite;

    public PagesaStrategy merrStrategjine(String tipi) {
        return strategjite.get(tipi);
    }
}
