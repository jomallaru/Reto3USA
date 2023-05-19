package com.example.Reto3.Repository;

import com.example.Reto3.Model.Message;
import com.example.Reto3.Repository.CRUD.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class MessageRepository {


    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> findAll (){
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }

    public Message save(Message message){
        return messageCrudRepository.save(message);

    }

    public void delete(Message message){
        messageCrudRepository.delete(message);
    }
}
