package com.ejercicio1.criss.service;

import com.ejercicio1.criss.model.Autor;
import com.ejercicio1.criss.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    public Autor getAutorById(Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor updateAutor(Integer id, Autor autor) {
        Optional<Autor> autorExistente = autorRepository.findById(id);
        if (autorExistente.isPresent()) {
            autor.setId(id); // Se corrigió el acceso al método setId()
            return autorRepository.save(autor);
        } else {
            return null; // Manejo de error opcional
        }
    }

    public void deleteAutor(Integer id) {
        autorRepository.deleteById(id);
    }
}
