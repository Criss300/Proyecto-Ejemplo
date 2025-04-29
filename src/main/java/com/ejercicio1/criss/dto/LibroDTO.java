package com.ejercicio1.criss.dto;

import java.util.List;

public class LibroDTO {
    private Integer id;
    private String titulo;
    private String isbn;
    private String fechaPublicacion;
    private String editorial;
    private List<String> autores;

    public LibroDTO() {
    }

    public LibroDTO(Integer id, String titulo, String isbn, String fechaPublicacion, String editorial,
            List<String> autores) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
        this.autores = autores;
    }

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

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    
    
}


