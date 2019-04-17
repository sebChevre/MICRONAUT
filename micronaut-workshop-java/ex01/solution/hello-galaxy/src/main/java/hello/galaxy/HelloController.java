package hello.galaxy;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloController {

//tag::action[]
    @Get("/")
    String index() {
        return "Hello Galaxy!";
    }
//end::action[]

}