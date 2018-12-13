package first.micronaut.domaine.repository;

import first.micronaut.domaine.Message;
import first.micronaut.domaine.command.CreateMessageCommand;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {

    Optional<Message> getMessageById(String id);

    Message sauveMessage(CreateMessageCommand command);

    List<Message> findAllMessages();
}
