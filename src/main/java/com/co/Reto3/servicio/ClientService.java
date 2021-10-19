package com.co.Reto3.servicio;

import com.co.Reto3.modelo.Client;
import com.co.Reto3.repositorio.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients () {
        return clientRepository.getAllClients();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client saveClient(Client cliente){
        if(cliente.getIdClient()==null){
            return clientRepository.saveClient(cliente);
        }else{
            Optional<Client> e=clientRepository.getClient(cliente.getIdClient());
            if(e.isEmpty()){
                return clientRepository.saveClient(cliente);
            }else{
                return cliente;
            }
        }
    }
}
