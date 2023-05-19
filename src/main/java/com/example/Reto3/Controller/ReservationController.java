package com.example.Reto3.Controller;

import com.example.Reto3.Model.Reservation;
import com.example.Reto3.Service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Reservation")

public class ReservationController {
    private ReservationService reservationService;

    @GetMapping("/all") // ->>>> localhost../api/Reservation/all
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}") // ->>>> localhost../api/Reservation/
    public Optional<Reservation> getReservation(@PathVariable int id){
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
}
