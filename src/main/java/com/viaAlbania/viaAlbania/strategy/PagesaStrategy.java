package com.viaAlbania.viaAlbania.strategy;

import com.viaAlbania.viaAlbania.entity.Pagesa;

public interface PagesaStrategy {
    void proceso(Pagesa pagesa);
    String gjeneroFature(Pagesa pagesa);
}
