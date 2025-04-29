package com.ejercicio1.criss.dto;

public class EjemplarDTO {
    private Integer id;
    private String codigoBarras;
    private String estado;
    private String libroTitulo;

    public EjemplarDTO() {
    }

    public EjemplarDTO(Integer id, String codigoBarras, String estado, String libroTitulo) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.estado = estado;
        this.libroTitulo = libroTitulo;
    }

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLibroTitulo() {
        return libroTitulo;
    }

    public void setLibroTitulo(String libroTitulo) {
        this.libroTitulo = libroTitulo;
    }

    
}
