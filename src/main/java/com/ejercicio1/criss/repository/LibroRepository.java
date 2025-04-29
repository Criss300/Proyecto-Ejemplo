package com.ejercicio1.criss.repository;

import com.ejercicio1.criss.model.libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<libro, Integer> {

    // ✅ Verificar si un libro existe por su ID
    boolean existsById(Integer id);

    // ✅ Buscar un libro por su título
    Optional<libro> findByTitulo(String titulo);
}
