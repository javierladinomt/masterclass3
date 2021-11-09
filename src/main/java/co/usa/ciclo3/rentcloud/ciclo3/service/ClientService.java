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
}
