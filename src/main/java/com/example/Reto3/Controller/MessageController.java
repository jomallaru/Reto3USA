package com.example.Reto3.Controller;

import com.example.Reto3.Model.Message;
import com.example.Reto3.Service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Message")

public class MessageController {
    private MessageService messageService;

    @GetMapping("/all") // ->>>> localhost../api/Message/all
    public List<Message> getAll(){
        return messageService.getAll();
    }

    @GetMapping("/{id}") // ->>>> localhost../api/Message/
    public Optional<Message> getMessage(@PathVariable int id){
        return messageService.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Message save(@RequestBody Message message){
        return messageService.save(message);
    }
}