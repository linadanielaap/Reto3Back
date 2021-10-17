package com.co.Reto3.controlador;

import com.co.Reto3.modelo.Message;
import com.co.Reto3.servicio.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class MessageController {
    @Autowired
    private MessageService msjService;

    @GetMapping("/all")
    public List<Message> getMessages (){
        return msjService.getAllMsj();
    }

    @PostMapping("/save")
    public Message saveMsj(@RequestBody Message msj){
        return msjService.saveMsj(msj);
    }
}
