package com.ejercicio1.criss.dto;
import java.util.Date;

public class ReservaDTO {
    private Integer id_reserva;
    private Date fechaReserva;
    private String usuarioNombre;
    private String ejemplarCodigoBarras;
    
    public ReservaDTO() {
    }

    public ReservaDTO(Integer id_reserva, Date fechaReserva, String usuarioNombre, String ejemplarCodigoBarras) {
        this.id_reserva = id_reserva;
        this.fechaReserva = fechaReserva;
        this.usuarioNombre = usuarioNombre;
        this.ejemplarCodigoBarras = ejemplarCodigoBarras;
    }

    public Integer getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Integer id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
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
