package com.ejercicio1.criss.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "libro")
public class libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(unique = true, nullable = false, length = 13)
    private String isbn;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "id_editorial", nullable = false)
    private Editorial editorial;

    public libro() {
        // Constructor vacío requerido por JPA
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { 
        this.id = id; 
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public java.util.Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(java.util.Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
}
