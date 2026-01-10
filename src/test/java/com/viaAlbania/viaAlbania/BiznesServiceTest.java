package com.viaAlbania.viaAlbania;

import com.viaAlbania.viaAlbania.entity.Biznes;
import com.viaAlbania.viaAlbania.repository.BiznesRep;
import com.viaAlbania.viaAlbania.service.BiznesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BiznesServiceTest {

    @Mock
    private BiznesRep biznesRep;

    @InjectMocks
    private BiznesService biznesService;

    private Biznes biznes;

    @BeforeEach
    void setUp() {
        biznes = new Biznes();
        biznes.setEmri("Restorant X");
        biznes.setAdresa("Rruga e Restoranteve, Tiranë");
        biznes.setTipi("Restorant");
        biznes.setKategoria("Gastronomi");
        biznes.setLatitude(41.3275);
        biznes.setLongitude(19.8189);
    }

    @Test
    void krijo_success() {
        when(biznesRep.save(any(Biznes.class))).thenAnswer(i -> i.getArgument(0));

        Biznes saved = biznesService.krijo(biznes);

        assertTrue(saved.isAktiv());
        assertNotNull(saved.getDataKrijimit());
        assertEquals("Restorant X", saved.getEmri());
        verify(biznesRep, times(1)).save(biznes);
    }

    @Test
    void perditesoTeDhenat_success() {
        Biznes updated = new Biznes();
        updated.setEmri("Restorant Y");
        updated.setPershkrimShtese("Pershkrim i ri");

        when(biznesRep.findById(1)).thenReturn(Optional.of(biznes));
        when(biznesRep.save(any(Biznes.class))).thenAnswer(i -> i.getArgument(0));

        Biznes result = biznesService.perditesoTeDhenat(1, updated);

        assertEquals("Restorant Y", result.getEmri());
        assertEquals("Pershkrim i ri", result.getPershkrimShtese());
        verify(biznesRep, times(1)).save(biznes);
    }

    @Test
    void perditesoTeDhenat_notFound() {
        when(biznesRep.findById(99)).thenReturn(Optional.empty());

        Biznes result = biznesService.perditesoTeDhenat(99, biznes);

        assertNull(result);
    }

    @Test
    void caktivizo_success() {
        when(biznesRep.findById(1)).thenReturn(Optional.of(biznes));
        when(biznesRep.save(any(Biznes.class))).thenAnswer(i -> i.getArgument(0));

        Biznes result = biznesService.caktivizo(1);

        assertFalse(result.isAktiv());
        verify(biznesRep, times(1)).save(biznes);
    }

    @Test
    void caktivizo_notFound() {
        when(biznesRep.findById(99)).thenReturn(Optional.empty());

        Biznes result = biznesService.caktivizo(99);

        assertNull(result);
    }

    @Test
    void vendosOraret_success() {
        when(biznesRep.findById(1)).thenReturn(Optional.of(biznes));
        when(biznesRep.save(any(Biznes.class))).thenAnswer(i -> i.getArgument(0));

        Biznes result = biznesService.vendosOraret(1, "08:00-22:00");

        assertEquals("08:00-22:00", result.getOrari());
        verify(biznesRep, times(1)).save(biznes);
    }

    @Test
    void vendosOraret_notFound() {
        when(biznesRep.findById(99)).thenReturn(Optional.empty());

        Biznes result = biznesService.vendosOraret(99, "08:00-22:00");

        assertNull(result);
    }

    @Test
    void perditesoCmimin_success() {
        when(biznesRep.findById(1)).thenReturn(Optional.of(biznes));
        when(biznesRep.save(any(Biznes.class))).thenAnswer(i -> i.getArgument(0));

        Biznes result = biznesService.perditesoCmimin(1, 25.50);

        assertEquals(25.50, result.getCmimMesatar());
        verify(biznesRep, times(1)).save(biznes);
    }

    @Test
    void perditesoCmimin_notFound() {
        when(biznesRep.findById(99)).thenReturn(Optional.empty());

        Biznes result = biznesService.perditesoCmimin(99, 25.50);

        assertNull(result);
    }

    @Test
    void perditesoDisponueshmerine_success() {
        when(biznesRep.findById(1)).thenReturn(Optional.of(biznes));
        when(biznesRep.save(any(Biznes.class))).thenAnswer(i -> i.getArgument(0));

        Biznes result = biznesService.perditesoDisponueshmerine(1, "Hapur");

        assertEquals("Hapur", result.getDisponueshmeri());
        verify(biznesRep, times(1)).save(biznes);
    }

    @Test
    void perditesoDisponueshmerine_notFound() {
        when(biznesRep.findById(99)).thenReturn(Optional.empty());

        Biznes result = biznesService.perditesoDisponueshmerine(99, "Hapur");

        assertNull(result);
    }

   
    @Test
    void merrTeGjitha_success() {
        List<Biznes> list = new ArrayList<>();
        list.add(biznes);

        when(biznesRep.findAll()).thenReturn(list);

        List<Biznes> result = biznesService.merrTeGjitha();

        assertEquals(1, result.size());
        verify(biznesRep, times(1)).findAll();
    }
}