package com.ejercicio1.criss.service;

import com.ejercicio1.criss.model.libro;
import com.ejercicio1.criss.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<libro> getAllLibros() {
        return libroRepository.findAll();
    }

    public libro getLibroById(Integer id) {
        return libroRepository.findById(id).orElse(null);
    }

    public libro createLibro(libro libro) {
        return libroRepository.save(libro);
    }

    public libro updateLibro(Integer id, libro libro) {
        Optional<libro> libroExistente = libroRepository.findById(id);
        if (libroExistente.isPresent()) {
            libro.setId(id);
            return libroRepository.save(libro);
        } else {
            return null;
        }
    }

    public void deleteLibro(Integer id) {
        libroRepository.deleteById(id);
    }
}
