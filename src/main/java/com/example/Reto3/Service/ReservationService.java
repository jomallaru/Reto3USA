package com.example.Reto3.Service;



import com.example.Reto3.Model.Client;
import com.example.Reto3.Model.DTOs.CompletedAndCancelled;
import com.example.Reto3.Model.DTOs.TotalAndClient;
import com.example.Reto3.Model.Reservation;
import com.example.Reto3.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.SimpleFormatter;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservationEncontrado = getReservation(reservation.getIdReservation());
            if (reservationEncontrado.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reservationEncontrado = getReservation(reservation.getIdReservation());
            if (reservationEncontrado.isPresent()) {
                if (reservation.getStartDate() != null) {
                    reservationEncontrado.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    reservationEncontrado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() !=null){
                    reservationEncontrado.get().setStatus(reservation.getStatus());
                }

                return reservationRepository.save(reservationEncontrado.get());
            }else{
                return reservation;
            }
        }else {
            return reservation;
        }
    }
    public boolean deleteReservation (int id){
        Boolean respuesta =getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return  respuesta;
    }
    //Reto 5

    public List<Reservation> getReservationBetweenDatesReport(String fechaA, String fechaB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date a = new Date();
        Date b = new Date();

        try {
            a = parser.parse(fechaA);
            b = parser.parse(fechaB);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        if (a.before(b)) {
            return reservationRepository.getReservationsBetweenDates(a, b);
        } else {
            return new ArrayList<>();
        }
    }

    public CompletedAndCancelled getReservationStatusReport() {
        List<Reservation> completed = reservationRepository.getReservationsByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationsByStatus("cancelled");

        Long cantidadCompletada = (long) completed.size();

        Long cantidadCancelada = (long) cancelled.size();

        CompletedAndCancelled respuesta = new CompletedAndCancelled(cantidadCompletada, cantidadCancelada);

        return respuesta;
    }

    public List<TotalAndClient> getTopClientsReport() {
        List<TotalAndClient> respuesta = new ArrayList<>();

        List<Object[]> reporte = reservationRepository.getTotalReservationsByClient();

        for (Object[] pareja : reporte) {
            respuesta.add(new TotalAndClient((Long) pareja[1], (Client) pareja[0]));
        }
        return respuesta;

    }

}
