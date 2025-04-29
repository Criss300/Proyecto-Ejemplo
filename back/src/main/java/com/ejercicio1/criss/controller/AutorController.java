package com.ejercicio1.criss.controller;

import com.ejercicio1.criss.model.Autor;
import com.ejercicio1.criss.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<List<Autor>> getAllAutores() {
        return ResponseEntity.ok(autorService.getAllAutores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Integer id) {
        return ResponseEntity.ok(autorService.getAutorById(id));
    }

    @PostMapping
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor) {
        return ResponseEntity.ok(autorService.createAutor(autor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Integer id, @RequestBody Autor autor) {
        return ResponseEntity.ok(autorService.updateAutor(id, autor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Integer id) {
        autorService.deleteAutor(id);
        return ResponseEntity.noContent().build();
    }
}
