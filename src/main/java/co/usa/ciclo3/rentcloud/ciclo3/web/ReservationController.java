package co.usa.ciclo3.rentcloud.ciclo3.web;

import co.usa.ciclo3.rentcloud.ciclo3.reports.ClientsCounter;
import co.usa.ciclo3.rentcloud.ciclo3.reports.ReservationStatus;
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
    public Optional<Reservation> getOne(@PathVariable ("id") int reservationId){
        return service.getReservation(reservationId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return service.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return service.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId){
        return service.delete(reservationId);
    }

    @GetMapping("/report-status")
    public ReservationStatus getReservation(){
        return service.getReservationStatusReport();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationTime (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo) {
        return service.getTimeReservationReport(dateOne, dateTwo);
    }
    @GetMapping("report-clients")
    public List<ClientsCounter> getClients(){
        return service.serviceTopClients();
    }
}
