package com.co.Reto5.servicio;

import com.co.Reto5.modelo.Boat;
import com.co.Reto5.modelo.Reservation;
import com.co.Reto5.modelo.custom.CountClient;
import com.co.Reto5.modelo.custom.StatusAmount;
import com.co.Reto5.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        if(reserva.getIdReservation()== null){
            return bookRepository.saveReservation(reserva);
        }else {
            Optional<Reservation> e= bookRepository.getReservation(reserva.getIdReservation());
            if (e.isEmpty()){
                return bookRepository.saveReservation(reserva);
            }else {
                return reserva;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= bookRepository.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                bookRepository.saveReservation(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            bookRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Reservation> getReservationPeriod (String interval1, String interval2) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha1 = new Date();
        Date fecha2 = new Date();
        try {
            fecha1 = parser.parse(interval1);
            fecha2 = parser.parse(interval2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (fecha1.before(fecha2)){
            return bookRepository.getReservationPeriod(fecha1,fecha2);
        }else{
            return new ArrayList<>();
        }
    }

    public List<CountClient> getTopClients(){
        return bookRepository.getTopClients();
    }

    public StatusAmount getStatus(){
        List<Reservation> completed = bookRepository.getReservationStatus("completed");
        List<Reservation> cancelled = bookRepository.getReservationStatus("cancelled");

        StatusAmount quantity = new StatusAmount(completed.size(),cancelled.size());
        return quantity;
    }
}
