package first.micronaut.application.api.web;

import first.micronaut.domaine.command.CreateMessageCommand;
import io.micronaut.http.sse.Event;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;
import io.reactivex.Emitter;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

import javax.inject.Singleton;

@Singleton
public class CommandPublisher implements Consumer<Emitter<Event<CreateMessageCommand>>>, ApplicationListener<CreateMessageCommand> {

    Logger log = LoggerFactory.getLogger(CommandPublisher.class.getName());

    private Emitter<Event<CreateMessageCommand>> eventEmmiter;



    @Override
    public void accept(Emitter<Event<CreateMessageCommand>> eventEmitter) throws Exception {
        log.info("**** ACCEPT *****");

        this.eventEmmiter = eventEmitter;

        log.info(this.eventEmmiter.toString());
        /**this.eventEmmiter.onNext(
                Event.of(new CreateMessageCommand("test sse"))
                     .id("toto")
                     .name("create-message-command")
        );**/
    }

    //@EventListener
    //@Async
    void onCareateMessageCommand(CreateMessageCommand command) {
        log.info("Event in: {}",command);
        this.eventEmmiter.onNext(Event.of(command));
    }

    @Override
    public void onApplicationEvent(CreateMessageCommand createMessageCommand) {
        log.info("Event in: {}",createMessageCommand);
        this.eventEmmiter.onNext(Event.of(createMessageCommand));
    }
}
