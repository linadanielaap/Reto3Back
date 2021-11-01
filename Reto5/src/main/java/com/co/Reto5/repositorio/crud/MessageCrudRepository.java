package com.co.Reto5.repositorio.crud;

import com.co.Reto5.modelo.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
