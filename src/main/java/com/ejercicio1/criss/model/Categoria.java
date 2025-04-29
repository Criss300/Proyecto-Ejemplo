package com.ejercicio1.criss.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    public Categoria() {
        // Constructor vacío requerido por JPA
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { 
        this.id = id; 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
