package co.usa.ciclo3.rentcloud.ciclo3.service;

import co.usa.ciclo3.rentcloud.ciclo3.model.Message;
import co.usa.ciclo3.rentcloud.ciclo3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public List<Message> getAll() {
        return repository.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return repository.getOne(messageId);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return repository.save(message);
        } else {
            Optional<Message> existMessage = repository.getOne(message.getIdMessage());
            if (existMessage.isEmpty()) {
                return repository.save(message);
            } else {
                return message;
            }
        }
    }
}
