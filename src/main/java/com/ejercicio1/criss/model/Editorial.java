package com.ejercicio1.criss.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "editorial")
public class Editorial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    @Column(length = 255)
    private String direccion;

    // Getters y Setters
}