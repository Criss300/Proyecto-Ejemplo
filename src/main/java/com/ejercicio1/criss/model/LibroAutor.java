package com.ejercicio1.criss.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libro_autor")
public class LibroAutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idLibro")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "idAutor")
    private Autor autor;

    // Getters y Setters
}