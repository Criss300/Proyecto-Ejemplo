package com.ejercicio1.criss.controller;

import com.ejercicio1.criss.model.libro;
import com.ejercicio1.criss.service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public ResponseEntity<List<libro>> getAllLibros() {
        return ResponseEntity.ok(libroService.getAllLibros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<libro> getLibroById(@PathVariable Integer id) {
        return ResponseEntity.ok(libroService.getLibroById(id));
    }

    @PostMapping
    public ResponseEntity<libro> createLibro(@RequestBody libro libro) {
        return ResponseEntity.ok(libroService.createLibro(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<libro> updateLibro(@PathVariable Integer id, @RequestBody libro libro) {
        return ResponseEntity.ok(libroService.updateLibro(id, libro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Integer id) {
        libroService.deleteLibro(id);
        return ResponseEntity.noContent().build();
    }
}

