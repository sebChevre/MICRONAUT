package fixtures.club;

import io.micronaut.http.annotation.Get;
import io.reactivex.Maybe;

public interface ClubsApi {


        @Get("/{id}")
        Maybe<Club> findTeam(Long id);



}
