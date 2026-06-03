package com.example.school2.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name ="Estudantes")
@Table(name = "TBL_ESTUDANTES")
@Data
public class EstudanteModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column (name = "nome_estudante")
    private String nome;

    @Column (name = "email_estudante")
    private String email;

    /*@CreationTimestamp
    private LocalDateTime dataMatricula;*/

}
