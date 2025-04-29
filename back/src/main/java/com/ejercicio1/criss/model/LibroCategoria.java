package com.ejercicio1.criss.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity(name = "libro_categoria")
public class LibroCategoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_libro", nullable = false)  // Corrección en el nombre de la columna
    private libro libro;  // Corrección de tipo (antes estaba en minúsculas)

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false) // Nombre unificado con la base de datos
    private Categoria categoria;

    public LibroCategoria() {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
