package com.viaAlbania.viaAlbania;

import com.viaAlbania.viaAlbania.entity.Pagesa;
import com.viaAlbania.viaAlbania.repository.PagesaRep;
import com.viaAlbania.viaAlbania.service.PagesaService;
import com.viaAlbania.viaAlbania.strategy.PagesaStrategy;
import com.viaAlbania.viaAlbania.strategy.PagesaStrategyFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PagesaServiceTest {

    @Mock
    private PagesaRep pagesaRep;

    @Mock
    private PagesaStrategyFactory strategyFactory;

    @Mock
    private PagesaStrategy strategy;

    @InjectMocks
    private PagesaService pagesaService;

    private Pagesa pagesa;

    @BeforeEach
    void setUp() {
        pagesa = new Pagesa();
        pagesa.setPagesaId(1);
        pagesa.setShuma(100.0);
    }

    @Test
    void ruajPagesen_shouldSetDateAndStatus() {
        when(pagesaRep.save(any(Pagesa.class))).thenAnswer(i -> i.getArgument(0));

        Pagesa saved = pagesaService.ruajPagesen(pagesa);

        assertEquals(LocalDate.now(), saved.getDataPageses());
        assertEquals("Nuk perfunduar", saved.getStatusi());
        assertEquals(100.0, saved.getShuma());
    }

    @Test
    void procesoPagesen_shouldUpdateStatus() {
        when(pagesaRep.findById(1)).thenReturn(Optional.of(pagesa));
        when(strategyFactory.merrStrategjine("Perfunduar")).thenReturn(strategy);

        // Mock për strategjinë që vendos statusin
        doAnswer(invocation -> {
            Pagesa p = invocation.getArgument(0);
            p.setStatusi("Perfunduar");
            return null;
        }).when(strategy).proceso(any(Pagesa.class));

        when(pagesaRep.save(pagesa)).thenReturn(pagesa);

        Pagesa result = pagesaService.procesoPagesen(1, "Perfunduar");

        assertNotNull(result);
        assertEquals("Perfunduar", result.getStatusi());
    }

    @Test
    void gjeneroFaturen_shouldReturnCorrectString() {
        pagesa.setStatusi("Perfunduar");
        when(pagesaRep.findById(1)).thenReturn(Optional.of(pagesa));
        when(strategyFactory.merrStrategjine("Pagese Itinerari")).thenReturn(strategy);
        when(strategy.gjeneroFature(pagesa)).thenReturn(
                "Fature Pagesa\nID Pagesa: 1\nShuma: 100.0\nStatusi: Perfunduar"
        );

        String fatura = pagesaService.gjeneroFaturen(1, "Pagese Itinerari");

        assertTrue(fatura.contains("ID Pagesa: 1"));
        assertTrue(fatura.contains("Shuma: 100.0"));
        assertTrue(fatura.contains("Statusi: Perfunduar"));
    }

    @Test
    void procesoPagesen_shouldReturnNullIfNotFound() {
        when(pagesaRep.findById(99)).thenReturn(Optional.empty());

        Pagesa result = pagesaService.procesoPagesen(99, "Perfunduar");

        assertNull(result);
    }

    @Test
    void gjeneroFaturen_shouldReturnNotFoundIfNotExist() {
        when(pagesaRep.findById(99)).thenReturn(Optional.empty());

        String fatura = pagesaService.gjeneroFaturen(99, "Pagese Itinerari");

        assertEquals("Pagesa nuk u gjet", fatura);
    }
}
