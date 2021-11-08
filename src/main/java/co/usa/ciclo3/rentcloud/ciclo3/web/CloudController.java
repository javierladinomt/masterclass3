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
    private CloudService cloudService;

    @GetMapping("/all")
    public List<Cloud> getClouds(){
        return cloudService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Cloud> getCloud(@PathVariable ("id") int id){
        return cloudService.getCloud(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud save(@RequestBody Cloud cloud){
        return cloudService.save(cloud);
    }
}
