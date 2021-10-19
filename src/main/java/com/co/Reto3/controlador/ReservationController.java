package com.co.Reto3.controlador;

import com.co.Reto3.modelo.Boat;
import com.co.Reto3.modelo.Reservation;
import com.co.Reto3.servicio.BoatService;
import com.co.Reto3.servicio.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class ReservationController {
    @Autowired
    private ReservationService bookService;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return bookService.getAllBooks();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation saveReservation(@RequestBody Reservation book){
        return bookService.saveReservation(book);
    }
}
