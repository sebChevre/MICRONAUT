package first.micronaut.application.api.web;

import io.micronaut.context.event.ApplicationEventPublisher;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;


@Controller("/hello")
public class HelloController {



    @Get(produces = MediaType.TEXT_PLAIN)
    String hello() {

        return "Hello World";
    }

    @Get(value = "/{nom}",produces = MediaType.TEXT_PLAIN)
    String helloWithName(String nom) {

        return "Hello " + nom;
    }
}
