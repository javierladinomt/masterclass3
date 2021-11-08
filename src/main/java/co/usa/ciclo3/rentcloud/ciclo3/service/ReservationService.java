package co.usa.ciclo3.rentcloud.ciclo3.service;

import co.usa.ciclo3.rentcloud.ciclo3.model.Reservation;
import co.usa.ciclo3.rentcloud.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAll(){
        return repository.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId){
        return repository.getReservation(reservationId);
    }

    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()==null){
            return repository.save(reservation);
        }else{
            Optional<Reservation> existReservation=repository.getReservation(reservation.getIdReservation());
            if(existReservation.isEmpty()){
                return repository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
}
