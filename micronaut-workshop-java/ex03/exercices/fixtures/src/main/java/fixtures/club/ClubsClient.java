package fixtures.club;

import io.micronaut.http.client.annotation.Client;

@Client("clubs-ex") // consul name
public interface ClubsClient extends ClubsApi {
}
