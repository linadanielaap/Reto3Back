package com.co.Reto3.servicio;

import com.co.Reto3.modelo.Boat;
import com.co.Reto3.modelo.Reservation;
import com.co.Reto3.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository bookRepository;

    public List<Reservation> getAllBooks (){
        return bookRepository.getAllBooks();
    }

    public Optional<Reservation> getReservation(int id){
        return bookRepository.getReservation(id);
    }

    public Reservation saveReservation(Reservation reserva){
        if(reserva.getIdReserva()== null){
            return bookRepository.saveReservation(reserva);
        }else {
            Optional<Reservation> e= bookRepository.getReservation(reserva.getIdReserva());
            if (e.isEmpty()){
                return bookRepository.saveReservation(reserva);
            }else {
                return reserva;
            }
        }
    }
}
