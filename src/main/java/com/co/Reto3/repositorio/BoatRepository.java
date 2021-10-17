package com.co.Reto3.repositorio;

import com.co.Reto3.modelo.Boat;
import com.co.Reto3.repositorio.crud.BoatCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoatRepository {

    @Autowired
    private BoatCrudRepository boatRepository;

    public List<Boat> getAll(){
        return (List<Boat>) boatRepository.findAll();

    }

    public Optional<Boat> getBoat(int id){
        return boatRepository.findById(id);
    }

    public Boat saveBoat(Boat barco){
        return boatRepository.save(barco);
    }
}
