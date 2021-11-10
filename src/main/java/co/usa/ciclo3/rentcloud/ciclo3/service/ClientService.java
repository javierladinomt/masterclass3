package co.usa.ciclo3.rentcloud.ciclo3.service;

import co.usa.ciclo3.rentcloud.ciclo3.model.Client;
import co.usa.ciclo3.rentcloud.ciclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    public List<Client> getAll(){
        return repository.getAll();
    }

    public Optional<Client> getClient(int clientId){
        return repository.getOne(clientId);
    }

    public Client save(Client category) {
        if (category.getIdClient() == null) {
            return repository.save(category);
        } else {
            Optional<Client> existClient = repository.getOne(category.getIdClient());
            if (existClient.isEmpty()) {
                return repository.save(category);
            } else {
                return category;
            }
        }
    }

    public Client update(Client client){
        if (client.getIdClient() != null){
            Optional<Client> existClient = repository.getOne(client.getIdClient());
            if (existClient.isPresent()){
                if (client.getName() != null){
                    existClient.get().setName(client.getName());
                }
                if (client.getEmail() != null){
                    existClient.get().setEmail(client.getEmail());
                }
                if (client.getMessages() != null){
                    existClient.get().setMessages(client.getMessages());
                }
                if (client.getAge() != null){
                    existClient.get().setAge(client.getAge());
                }
                if (client.getPassword() != null){
                    existClient.get().setPassword(client.getPassword());
                }
                if (client.getReservations() != null){
                    existClient.get().setReservations(client.getReservations());
                }
                return repository.save(existClient.get());
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean delete(int clientId){
        Boolean response = getClient(clientId).map(client -> {
            repository.delete(client);
            return true;
        }).orElse(false);
        return response;
    }
}
