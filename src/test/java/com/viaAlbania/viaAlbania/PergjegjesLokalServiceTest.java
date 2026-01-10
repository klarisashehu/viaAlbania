package com.viaAlbania.viaAlbania;

import com.viaAlbania.viaAlbania.entity.PergjegjesLokal;
import com.viaAlbania.viaAlbania.entity.PikaTuristike;
import com.viaAlbania.viaAlbania.repository.PergjegjesLokalRep;
import com.viaAlbania.viaAlbania.repository.PikaTuristikeRep;
import com.viaAlbania.viaAlbania.service.PergjegjesLokalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PergjegjesLokalServiceTest {

    @Mock
    private PergjegjesLokalRep lokalRep;

    @Mock
    private PikaTuristikeRep pikeRep;

    @InjectMocks
    private PergjegjesLokalService lokalService;

    private PergjegjesLokal lokal;
    private PikaTuristike pika;
    private BCryptPasswordEncoder encoder;

    @BeforeEach
    void setUp() {
        encoder = new BCryptPasswordEncoder();

        lokal = new PergjegjesLokal();
        lokal.setEmail("lokal@test.com");
        lokal.setFjalkalimi(encoder.encode("password123"));
        lokal.setEmer("Lokal Test");

        pika = new PikaTuristike();
        pika.setEmri("Parku Kombetar");
    }

    // ---------------- REGJISTROHU ----------------

    @Test
    void regjistrohu_success() {
        when(lokalRep.findByEmail("lokal@test.com")).thenReturn(Optional.of(lokal));

        Optional<PergjegjesLokal> result = lokalService.regjistrohu("lokal@test.com", "password123");

        assertTrue(result.isPresent());
        assertEquals("lokal@test.com", result.get().getEmail());
    }

    @Test
    void regjistrohu_fail_wrongPassword() {
        when(lokalRep.findByEmail("lokal@test.com")).thenReturn(Optional.of(lokal));

        Optional<PergjegjesLokal> result = lokalService.regjistrohu("lokal@test.com", "gabim");

        assertFalse(result.isPresent());
    }

    // ---------------- IDENTIFIKOHU ----------------

    @Test
    void identifikohu_success() {
        PergjegjesLokal newLokal = new PergjegjesLokal();
        newLokal.setEmail("new@test.com");
        newLokal.setFjalkalimi("plainPass");

        when(lokalRep.save(any(PergjegjesLokal.class)))
                .thenAnswer(i -> i.getArgument(0));

        PergjegjesLokal saved = lokalService.identifikohu(newLokal);

        assertNotNull(saved.getFjalkalimi());
        assertNotEquals("plainPass", saved.getFjalkalimi());
    }

    // ---------------- SHTO PIKE TURISTIKE ----------------

    @Test
    void shtoPikeTuristike_success() {
        when(pikeRep.save(any(PikaTuristike.class)))
                .thenAnswer(i -> i.getArgument(0));

        PikaTuristike saved = lokalService.shtoPikeTuristike(pika);

        assertEquals("Parku Kombetar", saved.getEmri());
        verify(pikeRep, times(1)).save(pika);
    }

    // ---------------- PERDITESO PIKE TURISTIKE ----------------

    @Test
    void perditesoPikeTuristike_success() {
        PikaTuristike updated = new PikaTuristike();
        updated.setEmri("Parku Kombetar Updated");

        when(pikeRep.findById(1)).thenReturn(Optional.of(pika));
        when(pikeRep.save(any(PikaTuristike.class))).thenAnswer(i -> i.getArgument(0));

        PikaTuristike result = lokalService.perditesoPikeTuristike(1, updated);

        assertEquals("Parku Kombetar Updated", result.getEmri());
    }

    @Test
    void perditesoPikeTuristike_notFound() {
        when(pikeRep.findById(99)).thenReturn(Optional.empty());

        PikaTuristike result = lokalService.perditesoPikeTuristike(99, pika);

        assertNull(result);
    }

    // ---------------- FSHI PIKE TURISTIKE ----------------

    @Test
    void fshiPikeTuristike_success() {
        when(pikeRep.existsById(1)).thenReturn(true);

        boolean result = lokalService.fshiPikeTuristike(1);

        assertTrue(result);
        verify(pikeRep, times(1)).deleteById(1);
    }

    @Test
    void fshiPikeTuristike_notFound() {
        when(pikeRep.existsById(99)).thenReturn(false);

        boolean result = lokalService.fshiPikeTuristike(99);

        assertFalse(result);
        verify(pikeRep, never()).deleteById(anyInt());
    }
}