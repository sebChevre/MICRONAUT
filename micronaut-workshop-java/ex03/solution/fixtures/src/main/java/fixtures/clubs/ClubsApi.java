package fixtures.clubs;

import io.micronaut.http.annotation.Get;
import io.reactivex.Maybe;

//tag::class[]
public interface ClubsApi {

    @Get("/{id}")
    Maybe<Club> findTeam(Long id);

}
//end::class[]
