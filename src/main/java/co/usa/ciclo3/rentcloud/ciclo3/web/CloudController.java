package co.usa.ciclo3.rentcloud.ciclo3.web;

import co.usa.ciclo3.rentcloud.ciclo3.model.Cloud;
import co.usa.ciclo3.rentcloud.ciclo3.service.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cloud")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CloudController {

    @Autowired
    private CloudService service;

    @GetMapping("/all")
    public List<Cloud> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Cloud> getOne(@PathVariable ("id") int cloudId){
        return service.getCloud(cloudId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud save(@RequestBody Cloud cloud){
        return service.save(cloud);
    }
}
