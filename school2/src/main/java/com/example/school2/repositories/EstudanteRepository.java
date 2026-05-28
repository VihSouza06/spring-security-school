package com.example.school2.repositories;

import com.example.school2.models.EstudanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface EstudanteRepository extends JpaRepository<EstudanteModel, Long> {
    UserDetails findByLogin(String role);
    boolean existsByNome(String nome);
}
