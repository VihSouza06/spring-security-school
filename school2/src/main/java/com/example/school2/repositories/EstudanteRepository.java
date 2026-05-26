package com.example.school2.repositories;

import com.example.school2.models.EstudanteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<EstudanteModel, Long> {
    boolean existsByNome(String nome);
}
