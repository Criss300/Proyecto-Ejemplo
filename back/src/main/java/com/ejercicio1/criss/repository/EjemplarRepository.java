package com.ejercicio1.criss.repository;

import com.ejercicio1.criss.model.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar, Integer> {
}
