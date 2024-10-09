package com.quality.workshop.rest;

import static com.quality.workshop.rest.RESTUtils.retrieveResourceFromResponse;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import com.quality.workshop.entity.Schauspieler;

/***
 * Quick example of an integration-test.
 * Run the project locally, then run the test
 */
public class ActorResourceIT {

    @Test
    public void testGetActorById() throws IOException {

        HttpUriRequest request = new HttpGet( "http://localhost:8082/actor/1" );

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        // Then
        Schauspieler actor = retrieveResourceFromResponse(
                httpResponse, Schauspieler.class);
        assertThat( actor.lastName,  Matchers.is("Cruise"  ) );
    }

    @Test
    public void testGetActorByName() throws IOException {

        HttpUriRequest request = new HttpGet( "http://localhost:8082/actor/Tom" );

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        // Then
        Schauspieler actor = retrieveResourceFromResponse(
                httpResponse, Schauspieler.class);
        assertThat( actor.lastName,  Matchers.is("Cruise"  ) );
    }


}
