package com.ejercicio1.criss.model;

import jakarta.persistence.*;

@Entity
@Table(name = "editorial")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEditorial;

    private String nombre;
    private String direccion;

    // Getters y Setters
}