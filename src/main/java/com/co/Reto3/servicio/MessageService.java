package com.co.Reto3.servicio;

import com.co.Reto3.modelo.Message;
import com.co.Reto3.repositorio.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository msjRepository;

    public List<Message> getAllMsj(){
        return msjRepository.getAllMsj();
    }

    public Optional<Message> getMessage(int id){
        return msjRepository.getMessage(id);
    }

    public Message saveMsj(Message mensaje){
        if(mensaje.getIdMessage()== null){
            return msjRepository.saveMessage(mensaje);
        }else {
            Optional<Message> e= msjRepository.getMessage(mensaje.getIdMessage());
            if (e.isEmpty()){
                return msjRepository.saveMessage(mensaje);
            }else {
                return mensaje;
            }
        }
    }
}
