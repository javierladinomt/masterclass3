package co.usa.ciclo3.rentcloud.ciclo3.repository;

import co.usa.ciclo3.rentcloud.ciclo3.model.Category;
import co.usa.ciclo3.rentcloud.ciclo3.model.Client;
import co.usa.ciclo3.rentcloud.ciclo3.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author JALP
 */
@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository repository;

    /**
     * SELECT * FROM CLIENT
     * @return Retorna todos los clientes
     */
    public List<Client> getAll(){
        return (List<Client>) this.repository.findAll();
    }

    /**
     * SELECT * FROM CLIENT WHERE ID = id
     * @param id
     * @return Retorna un cliente por su ID especifico
     */
    public Optional<Client> getOne(int id){
        return this.repository.findById(id);
    }

    /**
     * INSERT & UPDATE
     * @param client
     * @return Actualiza o guarda un cliente
     */
    public Client save(Client client){
        return this.repository.save(client);
    }

    /**
     * DELETE FROM TABLE
     * @param client
     */
    public void delete(Client client){
        this.repository.delete(client);
    }
}
