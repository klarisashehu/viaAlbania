package com.viaAlbania.viaAlbania.service;

import com.viaAlbania.viaAlbania.entity.Admin;
import com.viaAlbania.viaAlbania.repository.AdminRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRep adminRep;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Optional<Admin> regjistrohu(String email, String plainPassword) {
        Optional<Admin> adminOpt = adminRep.findByEmail(email);

        if (adminOpt.isPresent() &&
                passwordEncoder.matches(plainPassword, adminOpt.get().getFjalkalimi())) {
            return adminOpt;
        }
        return Optional.empty();
    }

    public Admin krijoAdmin(Admin newAdmin) {
        newAdmin.setFjalkalimi(passwordEncoder.encode(newAdmin.getFjalkalimi()));
        newAdmin.setDataKrijimit(LocalDate.now());
        newAdmin.setAktiv(false);
        return adminRep.save(newAdmin);
    }


    public Admin aktivizoAdmin(int adminId) {
        Optional<Admin> adminOpt = adminRep.findById(adminId);
        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();
            admin.setAktiv(true);
            return adminRep.save(admin);
        }
        return null;
    }


    public boolean aprovoBiznes(int biznesId) {
        // këtu normalisht do përdorej BiznesRepository
        // shembull logjik
        System.out.println("Biznesi me ID " + biznesId + " u aprovua nga admini.");
        return true;
    }
}
