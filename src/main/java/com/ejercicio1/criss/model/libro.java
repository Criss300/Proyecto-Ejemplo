package com.ejercicio1.criss.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

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
    private LocalDate fechaPublicacion; // ✅ Se cambia `java.util.Date` por `LocalDate`

    @ManyToOne
    @JoinColumn(name = "id_editorial", nullable = false)
    private Editorial editorial;

    public libro() {
        // Constructor vacío requerido por JPA
    }

    public libro(String titulo, String isbn, LocalDate fechaPublicacion, Editorial editorial) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
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

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    // ✅ Agregados para evitar errores en relaciones JPA
    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", editorial=" + (editorial != null ? editorial.getId() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof libro)) return false;
        libro libro = (libro) o;
        return Objects.equals(id, libro.id) &&
               Objects.equals(titulo, libro.titulo) &&
               Objects.equals(isbn, libro.isbn) &&
               Objects.equals(fechaPublicacion, libro.fechaPublicacion) &&
               Objects.equals(editorial, libro.editorial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, isbn, fechaPublicacion, editorial);
    }
}
