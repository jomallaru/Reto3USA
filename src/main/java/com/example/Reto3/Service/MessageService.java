package com.example.Reto3.Service;


import com.example.Reto3.Model.Message;
import com.example.Reto3.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MessageService {
    @Autowired

    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> messageEncontrado = getMessage(message.getIdMessage());
            if (messageEncontrado.isEmpty()) {
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }

    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> messageEncontrado = getMessage(message.getIdMessage());
            if (messageEncontrado.isPresent()) {

                if (message.getMessageText() != null) {
                    messageEncontrado.get().setMessageText(message.getMessageText());
                }
                if (message.getIdMessage() != null) {
                    messageEncontrado.get().setIdMessage(message.getIdMessage());
                }

                return messageRepository.save(messageEncontrado.get());
            }else{
                return message;
            }
        }else {
            return message;
        }
    }
    public boolean deleteMessage (int id){
        Boolean respuesta =getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return  respuesta;
    }

}
