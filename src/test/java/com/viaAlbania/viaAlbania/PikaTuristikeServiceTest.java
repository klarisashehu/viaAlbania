package com.viaAlbania.viaAlbania;

import com.viaAlbania.viaAlbania.entity.PikaTuristike;
import com.viaAlbania.viaAlbania.repository.PikaTuristikeRep;
import com.viaAlbania.viaAlbania.service.PikaTuristikeService;
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
class PikaTuristikeServiceTest {

    @Mock
    private PikaTuristikeRep pikaTuristikeRep;

    @InjectMocks
    private PikaTuristikeService pikaTuristikeService;

    private PikaTuristike pika;

    @BeforeEach
    void setUp() {
        pika = new PikaTuristike();
        pika.setEmri("Pika 1");
        pika.setAdresa("Rruga Test, Tirane");
        pika.setTipi("Muzeum");
        pika.setKategoria("Historik");
        pika.setLatitude(41.3275);
        pika.setLongitude(19.8189);
    }

    @Test
    void krijo_success() {
        when(pikaTuristikeRep.save(any(PikaTuristike.class))).thenAnswer(i -> i.getArgument(0));

        PikaTuristike saved = pikaTuristikeService.krijo(pika);

        assertTrue(saved.isAktiv());
        assertNotNull(saved.getDataKrijimit());
        assertEquals("Pika 1", saved.getEmri());
        verify(pikaTuristikeRep, times(1)).save(pika);
    }

    @Test
    void perditesoTeDhenat_success() {
        PikaTuristike updated = new PikaTuristike();
        updated.setEmri("Pika 2");
        updated.setPershkrimi("Pershkrim i ri");

        when(pikaTuristikeRep.findById(1)).thenReturn(Optional.of(pika));
        when(pikaTuristikeRep.save(any(PikaTuristike.class))).thenAnswer(i -> i.getArgument(0));

        PikaTuristike result = pikaTuristikeService.perditesoTeDhenat(1, updated);

        assertEquals("Pika 2", result.getEmri());
        assertEquals("Pershkrim i ri", result.getPershkrimi());
        verify(pikaTuristikeRep, times(1)).save(pika);
    }

    @Test
    void perditesoTeDhenat_notFound() {
        when(pikaTuristikeRep.findById(99)).thenReturn(Optional.empty());

        PikaTuristike result = pikaTuristikeService.perditesoTeDhenat(99, pika);

        assertNull(result);
    }

    @Test
    void caktivizo_success() {
        when(pikaTuristikeRep.findById(1)).thenReturn(Optional.of(pika));
        when(pikaTuristikeRep.save(any(PikaTuristike.class))).thenAnswer(i -> i.getArgument(0));

        PikaTuristike result = pikaTuristikeService.caktivizo(1);

        assertFalse(result.isAktiv());
        verify(pikaTuristikeRep, times(1)).save(pika);
    }

    @Test
    void caktivizo_notFound() {
        when(pikaTuristikeRep.findById(99)).thenReturn(Optional.empty());

        PikaTuristike result = pikaTuristikeService.caktivizo(99);

        assertNull(result);
    }

    @Test
    void vendosCmim_success() {
        when(pikaTuristikeRep.findById(1)).thenReturn(Optional.of(pika));
        when(pikaTuristikeRep.save(any(PikaTuristike.class))).thenAnswer(i -> i.getArgument(0));

        PikaTuristike result = pikaTuristikeService.vendosCmim(1, 15.5);

        assertEquals(15.5, result.getCmimi());
        verify(pikaTuristikeRep, times(1)).save(pika);
    }

    @Test
    void vendosCmim_notFound() {
        when(pikaTuristikeRep.findById(99)).thenReturn(Optional.empty());

        PikaTuristike result = pikaTuristikeService.vendosCmim(99, 15.5);

        assertNull(result);
    }

    @Test
    void merrTeGjitha_success() {
        List<PikaTuristike> list = new ArrayList<>();
        list.add(pika);

        when(pikaTuristikeRep.findAll()).thenReturn(list);

        List<PikaTuristike> result = pikaTuristikeService.merrTeGjitha();

        assertEquals(1, result.size());
        verify(pikaTuristikeRep, times(1)).findAll();
    }
}