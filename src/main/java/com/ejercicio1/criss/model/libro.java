package com.ejercicio1.criss.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;

    private String titulo;

    @Column(unique = true)
    private String isbn;

    private Date fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

    @ManyToMany
    @JoinTable(
        name = "LibroAutor",
        joinColumns = @JoinColumn(name = "id_libro"),
        inverseJoinColumns = @JoinColumn(name = "id_autor")
    )
    private Set<Autor> autores;

    @ManyToMany
    @JoinTable(
        name = "LibroCategoria",
        joinColumns = @JoinColumn(name = "id_libro"),
        inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private Set<Categoria> categorias;

    // Getters y Setters
}