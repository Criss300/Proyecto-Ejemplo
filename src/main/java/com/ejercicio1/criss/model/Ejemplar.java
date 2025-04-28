package com.ejercicio1.criss.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ejemplar")
public class Ejemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEjemplar;

    private String codigoBarras;
    private String estado; // Disponible, Prestado, Dañado, etc.

    @ManyToOne
    @JoinColumn(name = "idLibro")
    private Libro libro;

    // Getters y Setters
}
