package com.example.school2.models;

import com.example.school2.enums.EstudanteEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name ="Estudantes")
@Table(name = "TBL_ESTUDANTES")
@Data
public class EstudanteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "nome_estudante")
    private String nome;
    @Column (name = "email_estudante")
    private String email;
    @Column (name = "idade_estudante")
    private Integer idade;

    @CreationTimestamp
    private LocalDateTime dataMatricula;

    private EstudanteEnum estudanteEnum;

}
