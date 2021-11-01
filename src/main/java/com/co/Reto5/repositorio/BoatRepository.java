package com.co.Reto5.repositorio;

import com.co.Reto5.modelo.Boat;
import com.co.Reto5.repositorio.crud.BoatCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoatRepository {

    @Autowired
    private BoatCrudRepository crud;

    public List<Boat> getAll(){
        return (List<Boat>) crud.findAll();
    }

    public Optional<Boat> getBike(int id){
        return crud.findById(id);
    }

    public Boat save(Boat bike){
        return crud.save(bike);
    }

    public void delete(Boat boat){crud.delete(boat);}
}
