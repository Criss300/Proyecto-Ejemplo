package com.ejercicio1.criss.service;

import com.ejercicio1.criss.model.Reserva;
import com.ejercicio1.criss.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Reserva getReservaById(Integer id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public Reserva createReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva updateReserva(Integer id, Reserva reserva) {
        Optional<Reserva> reservaExistente = reservaRepository.findById(id);
        if (reservaExistente.isPresent()) {
            reserva.setId_reserva(id);
            return reservaRepository.save(reserva);
        } else {
            return null;
        }
    }

    public void deleteReserva(Integer id) {
        reservaRepository.deleteById(id);
    }
}

