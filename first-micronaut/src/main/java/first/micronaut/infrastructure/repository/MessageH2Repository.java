package first.micronaut.infrastructure.repository;

import first.micronaut.domaine.Message;
import first.micronaut.domaine.command.CreateMessageCommand;
import first.micronaut.domaine.repository.MessageRepository;


import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Singleton
public class MessageH2Repository implements MessageRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<Message> getMessageById(String id) {

        Message msg = entityManager.find(Message.class,Long.parseLong(id));

        return Optional.ofNullable(msg);
    }

    @Override
    public Message sauveMessage(CreateMessageCommand command) {

        Message message = command.toMessage();

        entityManager.persist(message);

        return message;
    }

    @Override
    public List<Message> findAllMessages() {
       Query q = entityManager.createQuery("SELECT e FROM Message e");

       return q.getResultList();

    }
}
