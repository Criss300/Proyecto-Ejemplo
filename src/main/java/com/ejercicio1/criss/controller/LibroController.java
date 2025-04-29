package com.ejercicio1.criss.controller;

import com.ejercicio1.criss.model.libro;
import com.ejercicio1.criss.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public ResponseEntity<String> createLibro(@RequestBody libro libro) {
        System.out.println("📩 JSON recibido en `POST`: " + libro);

        if (libro.getTitulo() == null || libro.getTitulo().trim().isEmpty() ||
            libro.getIsbn() == null || libro.getIsbn().trim().isEmpty() ||
            libro.getFechaPublicacion() == null ||
            libro.getEditorial() == null || libro.getEditorial().getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("❌ Todos los campos deben estar completos.");
        }

        libroService.createLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body("✅ Libro creado correctamente.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLibro(@PathVariable Integer id, @RequestBody libro libro) {
        System.out.println("📩 JSON recibido en `PUT`: " + libro);

        if (!libroService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("❌ Libro no encontrado.");
        }

        Optional<libro> libroActualizado = libroService.updateLibro(id, libro);
        return libroActualizado.map(l -> ResponseEntity.ok("✅ Libro actualizado correctamente."))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("❌ No se pudo actualizar el libro."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLibro(@PathVariable Integer id) {
        if (!libroService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("❌ Libro no encontrado.");
        }
        libroService.deleteLibro(id);
        return ResponseEntity.ok("✅ Libro eliminado correctamente.");
    }
}
