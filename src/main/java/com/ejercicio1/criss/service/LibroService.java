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

    // ✅ Obtener todos los libros
    public List<libro> findAll() {
        return libroRepository.findAll();
    }

    // ✅ Obtener un libro por ID
    public Optional<libro> getLibroById(Integer id) {
        return libroRepository.findById(id);
    }

    // ✅ Crear un nuevo libro con validaciones
    public libro createLibro(libro libro) {
        System.out.println("📤 Guardando libro en la base de datos: " + libro);

        if (libro.getTitulo() == null || libro.getTitulo().trim().isEmpty() ||
            libro.getIsbn() == null || libro.getIsbn().trim().isEmpty() ||
            libro.getFechaPublicacion() == null ||
            libro.getEditorial() == null || libro.getEditorial().getId() == null) {
            throw new IllegalArgumentException("❌ Todos los campos deben estar completos.");
        }

        return libroRepository.save(libro);
    }

    // ✅ Actualizar un libro solo si existe
    public Optional<libro> updateLibro(Integer id, libro libro) {
        if (!libroRepository.existsById(id)) {
            return Optional.empty();
        }

        return libroRepository.findById(id).map(libroExistente -> {
            libroExistente.setTitulo(libro.getTitulo());
            libroExistente.setIsbn(libro.getIsbn());
            libroExistente.setFechaPublicacion(libro.getFechaPublicacion());
            libroExistente.setEditorial(libro.getEditorial());
            return libroRepository.save(libroExistente);
        });
    }

    // ✅ Verificar existencia antes de eliminar
    public boolean existsById(Integer id) {
        return libroRepository.existsById(id);
    }

    // ✅ Eliminar un libro por ID
    public void deleteLibro(Integer id) {
        if (!existsById(id)) {
            throw new IllegalArgumentException("❌ El libro con ID " + id + " no existe.");
        }
        libroRepository.deleteById(id);
    }
}
