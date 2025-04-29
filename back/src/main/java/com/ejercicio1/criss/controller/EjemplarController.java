package com.ejercicio1.criss.controller;

import com.ejercicio1.criss.model.Ejemplar;
import com.ejercicio1.criss.service.EjemplarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejemplares")
public class EjemplarController {

    private final EjemplarService ejemplarService;

    public EjemplarController(EjemplarService ejemplarService) {
        this.ejemplarService = ejemplarService;
    }

    @GetMapping
    public ResponseEntity<List<Ejemplar>> getAllEjemplares() {
        return ResponseEntity.ok(ejemplarService.getAllEjemplares());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ejemplar> getEjemplarById(@PathVariable Integer id) {
        return ResponseEntity.ok(ejemplarService.getEjemplarById(id));
    }

    @PostMapping
    public ResponseEntity<Ejemplar> createEjemplar(@RequestBody Ejemplar ejemplar) {
        return ResponseEntity.ok(ejemplarService.createEjemplar(ejemplar));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ejemplar> updateEjemplar(@PathVariable Integer id, @RequestBody Ejemplar ejemplar) {
        return ResponseEntity.ok(ejemplarService.updateEjemplar(id, ejemplar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEjemplar(@PathVariable Integer id) {
        ejemplarService.deleteEjemplar(id);
        return ResponseEntity.noContent().build();
    }
}

