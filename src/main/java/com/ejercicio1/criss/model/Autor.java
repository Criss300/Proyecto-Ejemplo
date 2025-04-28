package com.ejercicio1.criss.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAutor;

    private String nombre;
    private String nacionalidad;

    @ManyToMany(mappedBy = "autores")
    private Set<Libro> libros;

    // Getters y setters
}
