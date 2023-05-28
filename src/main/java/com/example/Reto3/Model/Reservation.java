package com.example.Reto3.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name ="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    private Date startDate;

    private Date devolutionDate;

    private  String status = "created";


    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @ManyToOne
    @JoinColumn(name ="cardId")
    @JsonIgnoreProperties ("reservations")
    private  Car car;

    @ManyToOne
    @JoinColumn(name ="clientId")
    @JsonIgnoreProperties ({"reservations", "messages"})
    private  Client client;



    @OneToOne
    @JsonIgnoreProperties("reservation")
    private Score score;

}
