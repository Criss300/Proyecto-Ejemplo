package com.ejercicio1.criss.dto;

import java.util.Date;

public class PrestamoDTO {
    private Integer id_prestamo;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String usuarioNombre;
    private String ejemplarCodigoBarras;

    public PrestamoDTO() {
    }

    public PrestamoDTO(Integer id_prestamo, Date fechaPrestamo, Date fechaDevolucion, String usuarioNombre,
            String ejemplarCodigoBarras) {
        this.id_prestamo = id_prestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.usuarioNombre = usuarioNombre;
        this.ejemplarCodigoBarras = ejemplarCodigoBarras;
    }

    public Integer getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(Integer id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getEjemplarCodigoBarras() {
        return ejemplarCodigoBarras;
    }

    public void setEjemplarCodigoBarras(String ejemplarCodigoBarras) {
        this.ejemplarCodigoBarras = ejemplarCodigoBarras;
    }
 
}
