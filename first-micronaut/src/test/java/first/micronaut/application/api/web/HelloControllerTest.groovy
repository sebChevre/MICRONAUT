package first.micronaut.application.api.web

import groovy.json.JsonSlurper
import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class HelloControllerTest extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Shared
    @AutoCleanup
    HttpClient client = HttpClient.create(embeddedServer.URL)

    void "test hello world response"() {
        expect:
            client.toBlocking()
                .retrieve(HttpRequest.GET('/hello')) == "Hello World"
    }

    void "test hello nom response"() {
        expect:
            client.toBlocking()
                .retrieve(HttpRequest.GET('/hello/tutu')) == "Hello tutu"
    }

    void "test standards 404 no endpoint"() {
        when:
            client.toBlocking()
                .retrieve(HttpRequest.GET('/helloa/tutu')) == "Hello tutu"
        then:
            HttpClientResponseException e = thrown(HttpClientResponseException)
            e.status.code == 404
            def response =  e.response
            def jsonSlurper = new JsonSlurper()
            def body = jsonSlurper.parseText(response.body())
            body.message == "Page Not Found"
    }
}
