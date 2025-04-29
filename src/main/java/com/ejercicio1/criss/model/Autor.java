package com.ejercicio1.criss.model;

import jakarta.persistence.*;
import java.io.Serializable;

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

    public Autor() {
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
