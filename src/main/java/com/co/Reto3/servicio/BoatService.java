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
    private BoatRepository metodosCrud;

    public List<Boat> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Boat> getBike(int bikeId) {
        return metodosCrud.getBike(bikeId);
    }

    public Boat save(Boat bike){
        if(bike.getId()==null){
            return metodosCrud.save(bike);
        }else{
            Optional<Boat> e=metodosCrud.getBike(bike.getId());
            if(e.isEmpty()){
                return metodosCrud.save(bike);
            }else{
                return bike;
            }
        }
    }
}
