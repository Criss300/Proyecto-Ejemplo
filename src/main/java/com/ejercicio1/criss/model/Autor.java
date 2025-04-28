package com.ejercicio1.criss.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "autor")
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 50)
    private String nacionalidad;

    @ManyToMany(mappedBy = "autores")
    private Set<Libro> libros;

    public Autor() {
        // Constructor vacío requerido por Hibernate
    }

    // Getters y Setters
}
