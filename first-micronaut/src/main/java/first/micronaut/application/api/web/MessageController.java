package first.micronaut.application.api.web;

import first.micronaut.application.service.MessageService;
import first.micronaut.domaine.Message;
import first.micronaut.domaine.command.CreateMessageCommand;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Controller("/message")
public class MessageController {

    Logger log = LoggerFactory.getLogger(MessageController.class.getName());

    @Inject
    MessageService service;

    @Get("/{id}")
    public HttpResponse<Message> getById(String id){
        log.info("getById: {}",id);

        Optional<Message> message = service.getById(id);

        if(message.isPresent()) {
            return HttpResponse.ok(message.get());
        }else{
            return HttpResponse.notFound();
        }


    }

    @Get
    public HttpResponse<List<Message>> getAll(){
        log.info("getAll");

        List<Message> messages = service.getAllMessages();

        return HttpResponse.ok(messages);
    }

    @Post
    public HttpResponse<Message> sauveMessage(@Body CreateMessageCommand command){
        log.info("sauveMessage: {}",command);

        return HttpResponse.ok(service.sauveMessage(command));
    }
}
