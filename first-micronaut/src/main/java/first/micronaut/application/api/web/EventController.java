package first.micronaut.application.api.web;

import first.micronaut.domaine.Message;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.sse.Event;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

@Controller("/sse")
public class EventController {

    @Get
    public Publisher<Event<Message>> index() {


        return Flowable.generate(() -> 0, (i, emitter) -> {
            if (i < 10) {
                emitter.onNext(
                        Event.of(new Message("SSE msg n° " + i))
                             .id("toto")
                             .name("tete")
                );
            } else {
                emitter.onComplete();
            }

            Thread.sleep(1000);
            return ++i;
        });
    }
}
