package first.micronaut.application.api.web;

import com.sun.media.jfxmediaimpl.MediaDisposer;
import first.micronaut.domaine.Message;
import first.micronaut.domaine.command.CreateMessageCommand;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.discovery.event.ServiceStartedEvent;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.sse.Event;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;
import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.util.ConnectConsumer;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

@Controller("/sse")
public class EventController {

    Logger log = LoggerFactory.getLogger(EventController.class.getName());


    Flowable f = Flowable.empty();

    Subscriber s;

    @Get("/random")
    public Single<String> echo (String text) {
        return Single.just(">" + text);
    }





    @EventListener
    @Async
    void onCareateMessageCommand(CreateMessageCommand command) {
        log.info("Event: {}",command);
    }


    @Get
    public Publisher<Event<CreateMessageCommand>> index() throws Exception {

       //f.subscribe();

/**
        return new Publisher<Event<CreateMessageCommand>>() {
            @Override
            public void subscribe(Subscriber<? super Event<CreateMessageCommand>> subscriber) {

                while (true) {
                    subscriber.onNext(Event.of(new CreateMessageCommand("test sse2"))
                                           .id("toto")
                                           .name("create-message-command"));

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        log.info("fail");
                        e.printStackTrace();
                    }
                }
                //subscriber.onComplete();
            }
        };
        //c.accept(emit);

        //return Flowable.generate(c);

*/

/**
        return Flowable.generate(emitter -> {


            new ApplicationEventListener<CreateMessageCommand>() {
                @Override
                public void onApplicationEvent(CreateMessageCommand event) {

                    log.info("Event in: {}",event);

                    emitter.onNext(
                            Event.of(new CreateMessageCommand("test sse"))
                                 .id("toto")
                                 .name("create-message-command")
                    );
                }

            };



               // emitter.onComplete();

                //Thread.sleep(1000);

        });

*/
    return Flowable.generate(new CommandPublisher());
    }
}
