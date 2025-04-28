package com.ejercicio1.criss.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libro_categoria")
public class LibroCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idLibro")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    // Getters y Setters
}
