package com.example.Reto3.Repository.CRUD;


import com.example.Reto3.Model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository  extends CrudRepository<Message, Integer> {
}
