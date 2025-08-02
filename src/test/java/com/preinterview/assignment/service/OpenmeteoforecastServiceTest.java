package com.preinterview.assignment.service;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Tests for {@link OpenmeteoforecastService}.
 */
class OpenmeteoforecastServiceTest {

    @Test
    void returnsTemperatureFromApiResponse() {
        RestTemplate restTemplate = new RestTemplate();
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);

        OpenmeteoforecastService service = new OpenmeteoforecastService();
        service.restTemplate = restTemplate;

        double latitude = 10.0;
        double longitude = 20.0;

        String url = "https://api.open-meteo.com/v1/forecast?" +
                "latitude=" + latitude + "&longitude=" + longitude + "&current=temperature_2m";
        String json = "{\"current\":{\"temperature_2m\":15.5}}";

        server.expect(requestTo(url))
              .andRespond(withSuccess(json, MediaType.APPLICATION_JSON));

        double temperature = service.getTemperature(latitude, longitude);

        assertEquals(15.5, temperature);
        server.verify();
    }
}

