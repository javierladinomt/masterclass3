package co.usa.ciclo3.rentcloud.ciclo3.repository;

import co.usa.ciclo3.rentcloud.ciclo3.model.Message;
import co.usa.ciclo3.rentcloud.ciclo3.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author JALP
 */
@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository repository;

    /**
     * SELECT * FROM MESSAGE
     * @return Retorna todos los mensajes
     */
    public List<Message> getAll(){
        return (List<Message>) this.repository.findAll();
    }

    /**
     * SELECT * FROM MESSAGE WHERE ID = id
     * @param id
     * @return Retorna un mensaje por su ID especifico
     */
    public Optional<Message> getOne(int id) {
        return this.repository.findById(id);
    }

    /**
     * INSERT & UPDATE
     * @param message
     * @return Actualiza o guarda un Mensaje
     */
    public Message save(Message message) {
        return this.repository.save(message);
    }
}
