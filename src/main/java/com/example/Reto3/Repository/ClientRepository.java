package com.example.Reto3.Repository;

import com.example.Reto3.Model.Client;
import com.example.Reto3.Repository.CRUD.ClientCrudRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRespository clientCrudRepository;

    public List<Client> findAll (){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client client){
        return clientCrudRepository.save(client);

    }

    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
}
