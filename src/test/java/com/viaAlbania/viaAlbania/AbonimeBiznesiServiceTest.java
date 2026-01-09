package com.viaAlbania.viaAlbania;

import com.viaAlbania.viaAlbania.entity.AbonimeBiznesi;
import com.viaAlbania.viaAlbania.entity.Pagesa;
import com.viaAlbania.viaAlbania.repository.AbonimeBiznesiRep;
import com.viaAlbania.viaAlbania.service.AbonimeBiznesiService;
import com.viaAlbania.viaAlbania.service.PagesaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AbonimeBiznesiServiceTest {

    @Mock
    private AbonimeBiznesiRep rep;

    @Mock
    private PagesaService pagesaService;

    @InjectMocks
    private AbonimeBiznesiService service;

    private AbonimeBiznesi abonim;

    @BeforeEach
    void setUp() {
        abonim = new AbonimeBiznesi();
        abonim.setPagesa(new Pagesa());
    }

    @Test
    void ruajAbonimin_shouldSaveEntity() {
        when(rep.save(abonim)).thenReturn(abonim);

        AbonimeBiznesi saved = service.ruajAbonimin(abonim);

        assertEquals(abonim, saved);
    }

    @Test
    void procesoPagesen_shouldCallPagesaService() {
        abonim.getPagesa().setPagesaId(10);
        when(rep.findById(1)).thenReturn(Optional.of(abonim));
        when(rep.save(abonim)).thenReturn(abonim);

        AbonimeBiznesi result = service.procesoPagesen(1);

        assertEquals(abonim, result);
        verify(pagesaService).procesoPagesen(10, "ABONIM");
    }

    @Test
    void gjeneroFaturen_shouldReturnStringFromPagesaService() {
        abonim.getPagesa().setPagesaId(20);
        when(rep.findById(2)).thenReturn(Optional.of(abonim));
        when(pagesaService.gjeneroFaturen(20, "ABONIM")).thenReturn("FAKTURA ABONIM");

        String fatura = service.gjeneroFaturen(2);

        assertEquals("FAKTURA ABONIM", fatura);
    }
}
