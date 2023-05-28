package com.example.Reto3.Controller;

import com.example.Reto3.Model.DTOs.CompletedAndCancelled;
import com.example.Reto3.Model.DTOs.TotalAndClient;
import com.example.Reto3.Model.Reservation;
import com.example.Reto3.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Reservation")

public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all") //local host/api/Reservation/all
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}") //local host/api/Reservation/id
    public Optional<Reservation> getReservation(@PathVariable int id){
        return reservationService.getReservation(id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation reservation){
        return reservationService.save(reservation);


    }
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update (@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return reservationService.deleteReservation(id);

    }

    //Reto 5

    @GetMapping("/report-dates/{fecha1}/{fecha2}")
    public List<Reservation> getReservationsBetweenDatesReport(@PathVariable("fecha1") String fecha1, @PathVariable("fecha2") String fecha2) {
        return reservationService.getReservationBetweenDatesReport(fecha1, fecha2);
    }

    @GetMapping("/report-status")
    public CompletedAndCancelled getReservationsStatusReport(){
        return reservationService.getReservationStatusReport();
    }

    @GetMapping("/report-clients")
    public List<TotalAndClient>getTopClientsReport() {
        return reservationService.getTopClientsReport();
    }

}