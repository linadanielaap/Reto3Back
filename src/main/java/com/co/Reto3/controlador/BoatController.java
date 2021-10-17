package com.co.Reto3.controlador;

import com.co.Reto3.modelo.Boat;
import com.co.Reto3.servicio.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class BoatController {

    @Autowired
    private BoatService boatService;

    @GetMapping("/all")
    public List<Boat> getBoats(){
        return boatService.getAll();
    }

    @PostMapping("/save")
    public Boat saveBoat (@RequestBody Boat barco){
        return boatService.save(barco);
    }
}
