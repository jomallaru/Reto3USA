package com.example.Reto3.Repository.CRUD;


import com.example.Reto3.Model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
