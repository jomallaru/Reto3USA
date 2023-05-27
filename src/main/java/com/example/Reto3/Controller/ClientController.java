package com.example.Reto3.Controller;

import com.example.Reto3.Model.Client;
import com.example.Reto3.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Client")

public class ClientController {
    @Autowired
    private ClientService clientService;


    @GetMapping("/all") //local host/api/Client/all
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @GetMapping("/{id}") //local host/api/cClient/id
    public Optional<Client> getClient(@PathVariable int id){
        return clientService.getClient(id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save (@RequestBody Client client){
        return clientService.save(client);


    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update (@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return clientService.deleteClient(id);

    }
}