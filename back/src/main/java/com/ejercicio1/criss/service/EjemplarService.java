package com.ejercicio1.criss.service;

import com.ejercicio1.criss.model.Ejemplar;
import com.ejercicio1.criss.repository.EjemplarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EjemplarService {

    private final EjemplarRepository ejemplarRepository;

    public EjemplarService(EjemplarRepository ejemplarRepository) {
        this.ejemplarRepository = ejemplarRepository;
    }

    public List<Ejemplar> getAllEjemplares() {
        return ejemplarRepository.findAll();
    }

    public Ejemplar getEjemplarById(Integer id) {
        return ejemplarRepository.findById(id).orElse(null);
    }

    public Ejemplar createEjemplar(Ejemplar ejemplar) {
        return ejemplarRepository.save(ejemplar);
    }

    public Ejemplar updateEjemplar(Integer id, Ejemplar ejemplar) {
        Optional<Ejemplar> ejemplarExistente = ejemplarRepository.findById(id);
        if (ejemplarExistente.isPresent()) {
            ejemplar.setId(id);
            return ejemplarRepository.save(ejemplar);
        } else {
            return null;
        }
    }

    public void deleteEjemplar(Integer id) {
        ejemplarRepository.deleteById(id);
    }
}

