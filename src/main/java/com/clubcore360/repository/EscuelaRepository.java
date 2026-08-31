package com.clubcore360.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clubcore360.model.Escuela;

public interface EscuelaRepository extends JpaRepository<Escuela, Long> {
    boolean existsBySlug(String slug);
}
