package com.co.Reto3.controlador;

import com.co.Reto3.modelo.Client;
import com.co.Reto3.servicio.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClients(){
        return  clientService.getClients();
    }

    @PostMapping("/save")
    public Client saveClient(@RequestBody Client cliente){
        return clientService.saveClient(cliente);
    }
}
