package co.usa.ciclo3.rentcloud.ciclo3.repository;

import co.usa.ciclo3.rentcloud.ciclo3.model.Admin;
import co.usa.ciclo3.rentcloud.ciclo3.repository.crud.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author JALP
 */
@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository repository;


    /**
     * SELECT FROM ADMIN
     * @return Retorna todos los administradores
     */
    public List<Admin> getAll() {
        return (List<Admin>) this.repository.findAll();
    }

    /**
     * SELECT * FROM ADMIN WHERE ID = id
     * @param id
     * @return Retorna un administrador por su ID espefifico
     */
    public Optional<Admin> getOne(int id) {
        return this.repository.findById(id);
    }

    /**
     * INSERT & UPDATE
     * @param admin
     * @return Actualiza o guarda un administrador
     */
    public Admin save(Admin admin) {
        return this.repository.save(admin);
    }
}
