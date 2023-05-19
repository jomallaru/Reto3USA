package com.example.Reto3.Controller;

import com.example.Reto3.Model.Gama;
import com.example.Reto3.Service.GamaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Gama")

public class GamaController {
    private GamaService gamaService;

    @GetMapping("/all") // ->>>> localhost../api/Gama/all
    public List<Gama> getAll(){
        return gamaService.getAll();
    }

    @GetMapping("/{id}") // ->>>> localhost../api/Gama/
    public Optional<Gama> getGama(@PathVariable int id){
        return gamaService.getGama(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Gama save(@RequestBody Gama gama){
        return gamaService.save(gama);
    }
}