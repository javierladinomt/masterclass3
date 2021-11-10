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
        return repository.getOne(reservationId);
    }

    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()==null){
            return repository.save(reservation);
        }else{
            Optional<Reservation> existReservation=repository.getOne(reservation.getIdReservation());
            if(existReservation.isEmpty()){
                return repository.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation() != null){
            Optional<Reservation> existReservarion = repository.getOne(reservation.getIdReservation());
            if (existReservarion.isPresent()){
                if (reservation.getClient() != null){
                    existReservarion.get().setClient(reservation.getClient());
                }
                if (reservation.getCloud() != null){
                    existReservarion.get().setCloud(reservation.getCloud());
                }
                if (reservation.getDevolutionDate() != null){
                    existReservarion.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getScore() != null){
                    existReservarion.get().setScore(reservation.getScore());
                }
                if (reservation.getStatus() != null){
                    existReservarion.get().setStatus(reservation.getStatus());
                }
                if (reservation.getStartDate() != null){
                    existReservarion.get().setStartDate(reservation.getStartDate());
                }
                return repository.save(existReservarion.get());
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean delete(int reservationId){
        Boolean response = getReservation(reservationId).map(reservation -> {
            repository.delete(reservation);
            return true;
        }).orElse(false);
        return response;
    }
}
