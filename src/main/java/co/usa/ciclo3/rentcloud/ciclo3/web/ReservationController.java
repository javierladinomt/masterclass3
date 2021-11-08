package co.usa.ciclo3.rentcloud.ciclo3.web;

import co.usa.ciclo3.rentcloud.ciclo3.model.Reservation;
import co.usa.ciclo3.rentcloud.ciclo3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservation> getOne(@PathVariable ("id") int id){
        return service.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return service.save(reservation);
    }
}
