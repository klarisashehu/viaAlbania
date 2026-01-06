package com.viaAlbania.viaAlbania.repository;

import com.viaAlbania.viaAlbania.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRep extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByEmail(String email);
}

