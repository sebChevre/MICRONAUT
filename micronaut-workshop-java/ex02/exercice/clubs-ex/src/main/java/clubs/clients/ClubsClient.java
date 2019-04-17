package clubs.clients;

import clubs.ClubsApi;
import io.micronaut.http.client.annotation.Client;

@Client("/")
public interface ClubsClient extends ClubsApi {
}
