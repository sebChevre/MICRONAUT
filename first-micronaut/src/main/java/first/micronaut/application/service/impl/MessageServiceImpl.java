package first.micronaut.application.service.impl;

import first.micronaut.application.service.MessageService;
import first.micronaut.domaine.Message;
import first.micronaut.domaine.command.CreateMessageCommand;
import first.micronaut.domaine.repository.MessageRepository;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;


@Singleton
class MessageServiceImpl implements MessageService {

    @Inject
    MessageRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Message> getById(String id) {

        return repository.getMessageById(id);
    }

    @Transactional
    @Override
    public Message sauveMessage(CreateMessageCommand command) {
        return repository.sauveMessage(command);
    }

    @Transactional
    @Override
    public List<Message> getAllMessages() {
        List<Message> messages = repository.findAllMessages();

        return messages;
    }
}
