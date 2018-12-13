package first.micronaut.application.service;

import first.micronaut.domaine.Message;
import first.micronaut.domaine.command.CreateMessageCommand;
import io.micronaut.spring.tx.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    Optional<Message> getById(String id);

    @Transactional
    Message sauveMessage(CreateMessageCommand command);

    List<Message> getAllMessages();
}
