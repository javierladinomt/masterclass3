package co.usa.ciclo3.rentcloud.ciclo3.web;

import co.usa.ciclo3.rentcloud.ciclo3.model.Client;
import co.usa.ciclo3.rentcloud.ciclo3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<Client> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Client> getOne(@PathVariable ("id") int clientId){
        return service.getClient(clientId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return service.save(client);
    }
}
