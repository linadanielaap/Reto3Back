package com.co.Reto5.controlador;

import com.co.Reto5.modelo.Score;
import com.co.Reto5.servicio.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score saveScore (@RequestBody Score nota) {
        return scoreService.saveScore(nota);
    }
}
