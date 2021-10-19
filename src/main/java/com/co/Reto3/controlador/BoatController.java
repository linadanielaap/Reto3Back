package com.co.Reto3.controlador;

import com.co.Reto3.modelo.Boat;
import com.co.Reto3.servicio.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class BoatController {
    @Autowired
    private BoatService servicio;
    @GetMapping("/all")
    public List<Boat> getBikes(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Boat> getBike(@PathVariable("id") int bikeId) {
        return servicio.getBike(bikeId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save(@RequestBody Boat bike) {
        return servicio.save(bike);
    }
}
