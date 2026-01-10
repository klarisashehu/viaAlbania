package com.viaAlbania.viaAlbania;

import com.viaAlbania.viaAlbania.entity.Admin;
import com.viaAlbania.viaAlbania.entity.Biznes;
import com.viaAlbania.viaAlbania.repository.AdminRep;
import com.viaAlbania.viaAlbania.repository.BiznesRep;
import com.viaAlbania.viaAlbania.service.AdminService;
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
class AdminServiceTest {

    @Mock
    private AdminRep adminRep;

    @Mock
    private BiznesRep biznesRep;

    @InjectMocks
    private AdminService adminService;

    private BCryptPasswordEncoder encoder;
    private Admin admin;

    @BeforeEach
    void setUp() {
        encoder = new BCryptPasswordEncoder();

        admin = new Admin();
        admin.setEmail("admin@test.com");
        admin.setFjalkalimi(encoder.encode("password123"));
        admin.setAktiv(false);
    }

    @Test
    void regjistrohu_success() {
        when(adminRep.findByEmail("admin@test.com")).thenReturn(Optional.of(admin));

        Optional<Admin> result = adminService.regjistrohu("admin@test.com", "password123");

        assertTrue(result.isPresent());
        assertEquals("admin@test.com", result.get().getEmail());
    }

    @Test
    void regjistrohu_fail_wrongPassword() {
        when(adminRep.findByEmail("admin@test.com")).thenReturn(Optional.of(admin));

        Optional<Admin> result = adminService.regjistrohu("admin@test.com", "gabim");

        assertFalse(result.isPresent());
    }

    @Test
    void krijoAdmin_success() {
        Admin newAdmin = new Admin();
        newAdmin.setEmail("new@test.com");
        newAdmin.setFjalkalimi("plainPass");

        when(adminRep.save(any(Admin.class))).thenAnswer(i -> i.getArgument(0));

        Admin saved = adminService.krijoAdmin(newAdmin);

        assertNotNull(saved.getFjalkalimi());
        assertNotEquals("plainPass", saved.getFjalkalimi());
        assertEquals(LocalDate.now(), saved.getDataKrijimit());
        assertFalse(saved.getAktiv());
    }

    @Test
    void aktivizoAdmin_success() {
        when(adminRep.findById(1)).thenReturn(Optional.of(admin));
        when(adminRep.save(any(Admin.class))).thenAnswer(i -> i.getArgument(0));

        Admin result = adminService.aktivizoAdmin(1);

        assertTrue(result.getAktiv());
    }

    @Test
    void aktivizoAdmin_notFound() {
        when(adminRep.findById(99)).thenReturn(Optional.empty());

        Admin result = adminService.aktivizoAdmin(99);

        assertNull(result);
    }

    @Test
    void aprovoBiznes_success() {
        Biznes b = new Biznes();
        b.setAktiv(false);

        when(biznesRep.findById(1)).thenReturn(Optional.of(b));
        when(biznesRep.save(any(Biznes.class))).thenAnswer(i -> i.getArgument(0));

        boolean result = adminService.aprovoBiznes(1);

        assertTrue(result);
        assertTrue(b.getAktiv());
    }

    @Test
    void aprovoBiznes_notFound() {
        when(biznesRep.findById(99)).thenReturn(Optional.empty());

        boolean result = adminService.aprovoBiznes(99);

        assertFalse(result);
    }
}