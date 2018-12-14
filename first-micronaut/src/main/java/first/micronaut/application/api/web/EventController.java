package first.micronaut.application.api.web;

import first.micronaut.domaine.Message;
import first.micronaut.domaine.command.CreateMessageCommand;
import io.micronaut.discovery.event.ServiceStartedEvent;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.sse.Event;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;
import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/sse")
public class EventController {

    Logger log = LoggerFactory.getLogger(EventController.class.getName());


/**
    @EventListener
    @Async
    void onCreateMessageCommand(CreateMessageCommand command) {
        log.info("Event: {}",command);
        emitter.onNext(
                Event.of(command)
        );
    }


    @Get
    public Publisher<Event<CreateMessageCommand>> index() throws Exception {

        c.accept(emitter);

        return Flowable.generate(c);

        /**
        return Flowable.generate(emitter -> {

                emitter.onNext(
                        Event.of(new Message("SSE msg "))
                             .id("toto")
                             .name("tete")
                );

                emitter.onComplete();

                Thread.sleep(1000);

        });
         */

    /*}
}
