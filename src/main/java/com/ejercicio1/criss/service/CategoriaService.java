package com.ejercicio1.criss.service;

import com.ejercicio1.criss.model.Categoria;
import com.ejercicio1.criss.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Integer id, Categoria categoria) {
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(id);
        if (categoriaExistente.isPresent()) {
            categoria.setId(id);
            return categoriaRepository.save(categoria);
        } else {
            return null;
        }
    }

    public void deleteCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
