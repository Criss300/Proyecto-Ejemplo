package com.ejercicio1.criss.repository;

import com.ejercicio1.criss.model.libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<libro, Integer> {
}
