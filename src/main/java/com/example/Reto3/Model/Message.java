package com.example.Reto3.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name ="message")

public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    private  String messageText;


    public Integer getIdMessage() {
        return idMessage;
    }



    @ManyToOne
    @JoinColumn (name="carId")
    @JsonIgnoreProperties ({"messages", "reservations"})
    private Car car;

    @ManyToOne
    @JoinColumn (name ="clientId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public com.example.Reto3.Model.Car getCar() {
        return car;
    }

    public void setCar(com.example.Reto3.Model.Car car) {
        this.car = car;
    }

    public com.example.Reto3.Model.Client getClient() {
        return client;
    }

    public void setClient(com.example.Reto3.Model.Client client) {
        this.client = client;
    }
}
