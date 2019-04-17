package clubs.controller;

import clubs.ClubsApi;
import clubs.domain.Club;
import clubs.domain.ClubRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.validation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/")
@Validated
public class ClubController implements ClubsApi {

    private ClubRepository repository;

    public ClubController(ClubRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Club> listClubs() {
        return repository.findAll();
    }

    @Override
    public Club show(@NotNull Long id) {
        return repository.find(id).orElse(null);
    }

    @Override
    public Club save(@NotNull String nom, String stade) {
        return repository.save(nom, stade);
    }

}
