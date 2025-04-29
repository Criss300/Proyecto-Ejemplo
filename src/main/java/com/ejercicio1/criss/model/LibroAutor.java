package com.ejercicio1.criss.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity(name = "libro_autor")
public class LibroAutor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_libro", nullable = false)  // Nombre de columna corregido
    private libro libro;  // Cambio de tipo (antes estaba en minúscula)

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)  // Nombre unificado con la base de datos
    private Autor autor;

    public LibroAutor() {
        // Constructor vacío requerido por JPA
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public libro getLibro() {
        return libro;
    }

    public void setLibro(libro libro) {
        this.libro = libro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
