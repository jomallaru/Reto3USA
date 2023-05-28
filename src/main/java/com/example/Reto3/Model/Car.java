package com.example.Reto3.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="car")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idCar;

    private String name;

    private String brand;

    private Integer year;

    private  String description;


    @ManyToOne
    @JoinColumn(name= "gamaId")
    @JsonIgnoreProperties ("cars")
    private Gama gama;

    @OneToMany (cascade = {CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties({"car", "client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties ({"car", "client"})
    private  List<Reservation> reservations;

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gama getGama() {
        return gama;
    }

    public void setGama(Gama gama) {
        this.gama = gama;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
