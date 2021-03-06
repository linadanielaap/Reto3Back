package com.co.Reto5.controlador;

import com.co.Reto5.modelo.Boat;
import com.co.Reto5.modelo.Category;
import com.co.Reto5.modelo.Reservation;
import com.co.Reto5.modelo.custom.CountClient;
import com.co.Reto5.modelo.custom.StatusAmount;
import com.co.Reto5.servicio.BoatService;
import com.co.Reto5.servicio.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService bookService;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
        return bookService.getReservation(reservationId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation saveReservation(@RequestBody Reservation book){
        return bookService.saveReservation(book);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return bookService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return bookService.deleteReservation(reservationId);
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationDates(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return bookService.getReservationPeriod(dateOne,dateTwo);
    }

    @GetMapping("/report-status")
    public StatusAmount getReservationStatus(){
        return bookService.getStatus();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getTopClients (){
        return bookService.getTopClients();
    }
}
