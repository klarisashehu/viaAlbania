package com.viaAlbania.viaAlbania;

import com.viaAlbania.viaAlbania.entity.Lokacion;
import com.viaAlbania.viaAlbania.repository.LokacionRep;
import com.viaAlbania.viaAlbania.service.LokacionService;
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
class LokacionServiceTest {

    @Mock
    private LokacionRep lokacionRep;

    @InjectMocks
    private LokacionService lokacionService;

    private Lokacion lokacion;

    @BeforeEach
    void setUp() {
        lokacion = new Lokacion();
        lokacion.setEmri("Muzeu Historik");
        lokacion.setPershkrimi("Muze historik i qytetit");
        lokacion.setLatitude(41.3275);
        lokacion.setLongitude(19.8189);
        lokacion.setTipi("Muze");
        lokacion.setOrari("08:00-18:00");
        lokacion.setAdresa("Rruga e Muzeut, Tiranë");
    }

    // ---------------- KRIJO ----------------
    @Test
    void krijo_success() {
        when(lokacionRep.save(any(Lokacion.class))).thenAnswer(i -> i.getArgument(0));

        Lokacion saved = lokacionService.krijo(lokacion);

        assertTrue(saved.isAktiv());
        assertEquals("Muzeu Historik", saved.getEmri());
        verify(lokacionRep, times(1)).save(lokacion);
    }

    // ---------------- PERDITESO TE DHENAT ----------------
    @Test
    void perditesoTeDhenat_success() {
        Lokacion updated = new Lokacion();
        updated.setEmri("Muzeu i Ri");
        updated.setPershkrimi("Pershkrimi i ri");

        when(lokacionRep.findById(1)).thenReturn(Optional.of(lokacion));
        when(lokacionRep.save(any(Lokacion.class))).thenAnswer(i -> i.getArgument(0));

        Lokacion result = lokacionService.perditesoTeDhenat(1, updated);

        assertEquals("Muzeu i Ri", result.getEmri());
        assertEquals("Pershkrimi i ri", result.getPershkrimi());
        verify(lokacionRep, times(1)).save(lokacion);
    }

    @Test
    void perditesoTeDhenat_notFound() {
        when(lokacionRep.findById(99)).thenReturn(Optional.empty());

        Lokacion result = lokacionService.perditesoTeDhenat(99, lokacion);

        assertNull(result);
    }

    // ---------------- CAKTIVIZO ----------------
    @Test
    void caktivizo_success() {
        when(lokacionRep.findById(1)).thenReturn(Optional.of(lokacion));
        when(lokacionRep.save(any(Lokacion.class))).thenAnswer(i -> i.getArgument(0));

        Lokacion result = lokacionService.caktivizo(1);

        assertFalse(result.isAktiv());
        verify(lokacionRep, times(1)).save(lokacion);
    }

    @Test
    void caktivizo_notFound() {
        when(lokacionRep.findById(99)).thenReturn(Optional.empty());

        Lokacion result = lokacionService.caktivizo(99);

        assertNull(result);
    }
}