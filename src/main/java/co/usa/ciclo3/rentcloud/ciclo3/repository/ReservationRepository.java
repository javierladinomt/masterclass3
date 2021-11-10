package co.usa.ciclo3.rentcloud.ciclo3.repository;

import co.usa.ciclo3.rentcloud.ciclo3.model.Category;
import co.usa.ciclo3.rentcloud.ciclo3.model.Reservation;
import co.usa.ciclo3.rentcloud.ciclo3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author JALP
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository repository;

    /**
     * SELECT * FROM RESERVATION
     * @return Retorna todas las reservas
     */
    public List<Reservation> getAll() {
        return (List<Reservation>) this.repository.findAll();
    }

    /**
     * SELECT * FROM RESERVATION WHERE ID = id
     * @param id
     * @return Retorna una reserva por su ID especifico
     */
    public Optional<Reservation> getOne(int id) {
        return this.repository.findById(id);
    }

    /**
     * INSERT & UPDATE
     * @param reservation
     * @return Actualiza o guarda una reserva
     */
    public Reservation save(Reservation reservation) {
        return this.repository.save(reservation);
    }

    /**
     * DELETE FROM TABLE
     * @param reservation
     */
    public void delete(Reservation reservation){
        this.repository.delete(reservation);
    }
}
