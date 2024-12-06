package com.preinterview.assignment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class OpenmeteoforecastService {

    @Autowired
    RestTemplate restTemplate;
    public Object getTemparature(double latitude, double longitude){
        String URL = "https://api.open-meteo.com/v1/forecast?" +
                "latitude=" + latitude + "&longitude=" + longitude + "&current=temperature_2m";
        //response from the open-meteo forcast API
        ResponseEntity<String> response
                = restTemplate.getForEntity(URL, String.class);
        // ObjectMapper to get temprature from the response
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        JsonNode current = root.path("current");
        return current.path("temperature_2m");
    }
}
