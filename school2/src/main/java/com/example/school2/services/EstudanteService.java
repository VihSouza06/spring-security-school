package com.example.school2.services;

import com.example.school2.models.EstudanteModel;
import com.example.school2.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {
    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<EstudanteModel> findAll(){
        return estudanteRepository.findAll();
    }

    public EstudanteModel criarEstudante(EstudanteModel estudanteModel){
        if (estudanteRepository.existsByNome(estudanteModel.getNome())) {
            throw new RuntimeException("Já existe um estudante com esse nome.");
        }

        return estudanteRepository.save(estudanteModel);
    }

    public void deletarEstudante(Long id){
        estudanteRepository.deleteById(id);
    }

    public EstudanteModel buscarEstudante(Long id){
        return estudanteRepository.findById(id).get();
    }

    public EstudanteModel atualizarEstudante(EstudanteModel estudanteModel, Long id){
        EstudanteModel novoEstudante = estudanteRepository.findById(id).get();
        novoEstudante.setNome(estudanteModel.getNome());
        novoEstudante.setEmail(estudanteModel.getEmail());
        novoEstudante.setIdade(estudanteModel.getIdade());
        return estudanteRepository.save(novoEstudante);
    }
}
