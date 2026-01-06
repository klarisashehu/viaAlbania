package com.viaAlbania.viaAlbania.controller;

import com.viaAlbania.viaAlbania.entity.Admin;
import com.viaAlbania.viaAlbania.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Optional<Admin> login(@RequestParam String email,
                                 @RequestParam String fjalkalimi) {
        return adminService.regjistrohu(email, fjalkalimi);
    }

    @PostMapping("/register")
    public Admin register(@RequestBody Admin admin) {
        return adminService.krijoAdmin(admin);
    }


    @PutMapping("/aktivizo/{id}")
    public Admin aktivizoAdmin(@PathVariable int id) {
        return adminService.aktivizoAdmin(id);
    }


    @PutMapping("/aprovo-biznes/{biznesId}")
    public String aprovoBiznes(@PathVariable int biznesId) {
        boolean aprovuar = adminService.aprovoBiznes(biznesId);
        return aprovuar ? "Biznesi u aprovua me sukses" : "Gabim në aprovimin e biznesit";
    }
}
