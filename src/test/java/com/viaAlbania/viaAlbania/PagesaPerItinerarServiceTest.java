package com.viaAlbania.viaAlbania;

import com.viaAlbania.viaAlbania.entity.Pagesa;
import com.viaAlbania.viaAlbania.entity.PagesaPerItinerar;
import com.viaAlbania.viaAlbania.entity.PagesaPerItinerarId;
import com.viaAlbania.viaAlbania.repository.PagesaPerItinerarRep;
import com.viaAlbania.viaAlbania.service.PagesaPerItinerarService;
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
class PagesaPerItinerarServiceTest {

    @Mock
    private PagesaPerItinerarRep rep;

    @Mock
    private PagesaService pagesaService;

    @InjectMocks
    private PagesaPerItinerarService service;

    private PagesaPerItinerar ppi;
    private PagesaPerItinerarId id;
    private Pagesa pagesa;

    @BeforeEach
    void setUp() {
        id = new PagesaPerItinerarId(1, 2);
        pagesa = new Pagesa();
        pagesa.setPagesaId(10);
        pagesa.setStatusi("Nuk perfunduar");

        ppi = new PagesaPerItinerar();
        ppi.setPagesa(pagesa);
        ppi.setLlojiSherbimit("Test");
    }

    @Test
    void ruaj_shouldSaveEntity() {
        when(rep.save(ppi)).thenReturn(ppi);

        PagesaPerItinerar saved = service.ruaj(ppi);

        assertEquals(ppi, saved);
    }

    @Test
    void procesoPages_shouldCallPagesaServiceAndReturnUpdated() {
        when(rep.findById(id)).thenReturn(Optional.of(ppi));
        when(pagesaService.procesoPagesen(pagesa.getPagesaId(), "ITINERAR")).thenReturn(pagesa);
        when(rep.save(ppi)).thenReturn(ppi);

        PagesaPerItinerar result = service.procesoPages(id);

        assertNotNull(result);
        verify(pagesaService).procesoPagesen(pagesa.getPagesaId(), "ITINERAR");
        assertEquals(ppi, result);
    }

    @Test
    void procesoPages_shouldReturnNullIfNotFound() {
        when(rep.findById(id)).thenReturn(Optional.empty());

        PagesaPerItinerar result = service.procesoPages(id);

        assertNull(result);
    }

    @Test
    void gjeneroFaturen_shouldReturnStringFromPagesaService() {
        when(rep.findById(id)).thenReturn(Optional.of(ppi));
        when(pagesaService.gjeneroFaturen(pagesa.getPagesaId(), "ITINERAR"))
                .thenReturn("Fature PagesaPerItinerar\nID Pagesa: 10");

        String fatura = service.gjeneroFaturen(id);

        assertNotNull(fatura);
        assertTrue(fatura.contains("ID Pagesa: 10"));
    }

    @Test
    void gjeneroFaturen_shouldReturnNotFoundIfNotExist() {
        when(rep.findById(id)).thenReturn(Optional.empty());

        String fatura = service.gjeneroFaturen(id);

        assertEquals("Pagesa per itinerar nuk u gjet", fatura);
    }

    @Test
    void zgjidhLlojinESherbimit_shouldUpdateLloji() {
        when(rep.findById(id)).thenReturn(Optional.of(ppi));
        when(rep.save(ppi)).thenReturn(ppi);

        PagesaPerItinerar result = service.zgjidhLlojinESherbimit(id, "NewLloji");

        assertEquals("NewLloji", result.getLlojiSherbimit());
    }

    @Test
    void verifikoPagesen_shouldReturnOptional() {
        when(rep.findById(id)).thenReturn(Optional.of(ppi));

        Optional<PagesaPerItinerar> result = service.verifikoPagesen(id);

        assertTrue(result.isPresent());
        assertEquals(ppi, result.get());
    }
}
