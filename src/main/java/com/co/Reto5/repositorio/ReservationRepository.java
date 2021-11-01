package com.co.Reto5.repositorio;

import com.co.Reto5.modelo.Client;
import com.co.Reto5.modelo.Reservation;
import com.co.Reto5.modelo.custom.CountClient;
import com.co.Reto5.repositorio.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository bookRepository;

    public List<Reservation> getAllBooks(){
        return (List<Reservation>) bookRepository.findAll();

    }

    public Optional<Reservation> getReservation(int id){
        return bookRepository.findById(id);
    }

    public Reservation saveReservation(Reservation reserva){
        return bookRepository.save(reserva);
    }

    public void delete(Reservation reservation){bookRepository.delete(reservation);}

    public List<Reservation> getReservationPeriod(Date interval1, Date interval2){
        return bookRepository.findAllByStartDateAfterAndStartDateBefore(interval1,interval2);
    }

    public List<Reservation> getReservationStatus(String status){
        return bookRepository.findAllByStatus(status);
    }

    public List<CountClient> getTopClients (){
        List<CountClient> res = new ArrayList<>();
        List<Object[]> report = bookRepository.countTotalReservationsByClient();
        for(int i=0; i<report.size();i++){
            res.add(new CountClient((Long) report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }
}
