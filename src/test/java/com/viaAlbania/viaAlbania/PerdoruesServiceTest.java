package com.viaAlbania.viaAlbania;

import com.viaAlbania.viaAlbania.entity.Perdorues;
import com.viaAlbania.viaAlbania.repository.PerdoruesRep;
import com.viaAlbania.viaAlbania.service.PerdoruesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PerdoruesServiceTest {

    @Mock
    private PerdoruesRep perdoruesRep;

    @InjectMocks
    private PerdoruesService perdoruesService;

    private BCryptPasswordEncoder encoder;
    private Perdorues perdorues;

    @BeforeEach
    void setUp() {
        encoder = new BCryptPasswordEncoder();

        perdorues = new Perdorues();
        perdorues.setEmail("test@test.com");
        perdorues.setFjalkalimi(encoder.encode("password123"));
        perdorues.setEmer("Test");
        perdorues.setMbiemer("User");
    }

    @Test
    void regjistrohu_success() {
        when(perdoruesRep.findByEmail("test@test.com"))
                .thenReturn(Optional.of(perdorues));

        Optional<Perdorues> result =
                perdoruesService.regjistrohu("test@test.com", "password123");

        assertTrue(result.isPresent());
        assertEquals("test@test.com", result.get().getEmail());
    }

    @Test
    void regjistrohu_fail_wrongPassword() {
        when(perdoruesRep.findByEmail("test@test.com"))
                .thenReturn(Optional.of(perdorues));

        Optional<Perdorues> result =
                perdoruesService.regjistrohu("test@test.com", "gabim");

        assertFalse(result.isPresent());
    }

    @Test
    void identifikohu_success() {
        Perdorues newUser = new Perdorues();
        newUser.setEmail("new@test.com");
        newUser.setFjalkalimi("plainPass");

        when(perdoruesRep.save(any(Perdorues.class)))
                .thenAnswer(i -> i.getArgument(0));

        Perdorues savedUser = perdoruesService.identifikohu(newUser);

        assertNotNull(savedUser.getFjalkalimi());
        assertNotEquals("plainPass", savedUser.getFjalkalimi());
        assertEquals(LocalDate.now(), savedUser.getDataKrijimit());
    }

    @Test
    void perditesoTeDhena_success() {
        when(perdoruesRep.findById(1))
                .thenReturn(Optional.of(perdorues));
        when(perdoruesRep.save(any(Perdorues.class)))
                .thenAnswer(i -> i.getArgument(0));

        Perdorues updated = new Perdorues();
        updated.setEmer("Updated");
        updated.setMbiemer("Name");
        updated.setEmail("updated@test.com");
        updated.setFjalkalimi("newPassword");

        Perdorues result =
                perdoruesService.perditesoTeDhena(1, updated);

        assertEquals("Updated", result.getEmer());
        assertEquals("Name", result.getMbiemer());
        assertEquals("updated@test.com", result.getEmail());
        assertTrue(encoder.matches("newPassword", result.getFjalkalimi()));
    }

    @Test
    void perditesoTeDhena_userNotFound() {
        when(perdoruesRep.findById(99))
                .thenReturn(Optional.empty());

        Perdorues result =
                perdoruesService.perditesoTeDhena(99, new Perdorues());

        assertNull(result);
    }
}

