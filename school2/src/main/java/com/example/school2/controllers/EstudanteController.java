package com.example.school2.controllers;

import com.example.school2.models.EstudanteModel;
import com.example.school2.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public ResponseEntity<List<EstudanteModel>> findAll(){
        List<EstudanteModel> estudantes = estudanteService.findAll();
        return ResponseEntity.ok(estudantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudanteModel> buscarEstudante(@PathVariable UUID id){
        EstudanteModel estudante = estudanteService.buscarEstudante(id);
        return ResponseEntity.ok(estudante);
    }

    @PostMapping
    public ResponseEntity<EstudanteModel> criarEstudante(@RequestBody EstudanteModel estudanteModel){
        EstudanteModel estudanteCriado = estudanteService.criarEstudante(estudanteModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(estudanteCriado.getId()).toUri();
        return ResponseEntity.created(uri).body(estudanteCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEstudante(@PathVariable UUID id){
        estudanteService.deletarEstudante(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudanteModel> atualizarEstudante
            (@PathVariable UUID id, @RequestBody EstudanteModel estudanteModel){
        EstudanteModel estudanteAtualizado = estudanteService.atualizarEstudante(estudanteModel, id);
        return ResponseEntity.ok(estudanteAtualizado);
    }

}
