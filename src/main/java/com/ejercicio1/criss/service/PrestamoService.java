package com.ejercicio1.criss.service;

import com.ejercicio1.criss.model.Prestamo;
import com.ejercicio1.criss.repository.PrestamoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    public Prestamo getPrestamoById(Integer id) {
        return prestamoRepository.findById(id).orElse(null);
    }

    public Prestamo createPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public Prestamo updatePrestamo(Integer id, Prestamo prestamo) {
        Optional<Prestamo> prestamoExistente = prestamoRepository.findById(id);
        if (prestamoExistente.isPresent()) {
            prestamo.setId_prestamo(id);
            return prestamoRepository.save(prestamo);
        } else {
            return null;
        }
    }

    public void deletePrestamo(Integer id) {
        prestamoRepository.deleteById(id);
    }
}
