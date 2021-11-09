package co.usa.ciclo3.rentcloud.ciclo3.repository;

import co.usa.ciclo3.rentcloud.ciclo3.model.Cloud;
import co.usa.ciclo3.rentcloud.ciclo3.repository.crud.CloudCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author JALP
 */
@Repository
public class CloudRepository {

    @Autowired
    private CloudCrudRepository repository;

    /**
     * SELECT * FROM CLOUD
     * @return Retorna todos las nubes
     */

    public List<Cloud> getAll(){
        return (List<Cloud>) this.repository.findAll();
    }

    /**
     * SELECT * FROM CLOUD HERE ID = id
     * @param id
     * @return Retorna una nube por su ID especifico
     */
    public Optional<Cloud> getOne(int id){
        return this.repository.findById(id);
    }

    /**
     * INSERT & UPDATE
     * @param cloud
     * @return Actualiza o guarda una nube
     */
    public Cloud save(Cloud cloud){
        return this.repository.save(cloud);
    }
}
