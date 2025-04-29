package com.ejercicio1.criss.controller;

import com.ejercicio1.criss.model.Prestamo;
import com.ejercicio1.criss.service.PrestamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping
    public ResponseEntity<List<Prestamo>> getAllPrestamos() {
        return ResponseEntity.ok(prestamoService.getAllPrestamos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getPrestamoById(@PathVariable Integer id) {
        return ResponseEntity.ok(prestamoService.getPrestamoById(id));
    }

    @PostMapping
    public ResponseEntity<Prestamo> createPrestamo(@RequestBody Prestamo prestamo) {
        return ResponseEntity.ok(prestamoService.createPrestamo(prestamo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> updatePrestamo(@PathVariable Integer id, @RequestBody Prestamo prestamo) {
        return ResponseEntity.ok(prestamoService.updatePrestamo(id, prestamo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable Integer id) {
        prestamoService.deletePrestamo(id);
        return ResponseEntity.noContent().build();
    }
}

