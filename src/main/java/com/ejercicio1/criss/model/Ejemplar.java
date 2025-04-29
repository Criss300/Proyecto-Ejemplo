package com.ejercicio1.criss.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ejemplar")
public class Ejemplar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String codigoBarras;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoEjemplar estado;

    @ManyToOne
    @JoinColumn(name = "id_libro", nullable = false)
    private libro libro; // Asegurar que "libro" esté en minúscula

    public Ejemplar() {
        // Constructor vacío requerido por JPA
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { 
        this.id = id; 
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public EstadoEjemplar getEstado() {
        return estado;
    }

    public void setEstado(EstadoEjemplar estado) {
        this.estado = estado;
    }

    public libro getLibro() {
        return libro;
    }

    public void setLibro(libro libro) {
        this.libro = libro;
    }
}
