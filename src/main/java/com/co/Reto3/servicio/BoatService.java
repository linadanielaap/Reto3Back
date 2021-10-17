package com.co.Reto3.servicio;

import com.co.Reto3.modelo.Boat;
import com.co.Reto3.repositorio.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {
    @Autowired
    private BoatRepository boatRepository;

    public List<Boat> getAll(){
        return boatRepository.getAll();
    }

    public Optional<Boat> getBoat(int id){
        return boatRepository.getBoat(id);
    }

    public Boat save(Boat barco){
        if(barco.getIdBoat()== null){
            return boatRepository.saveBoat(barco);
        }else {
            Optional<Boat> e= boatRepository.getBoat(barco.getIdBoat());
            if (e.isEmpty()){
                return boatRepository.saveBoat(barco);
            }else {
                return barco;
            }
        }
    }
}
