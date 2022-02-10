package com.example.csfassessment.services;

import com.example.csfassessment.repository.CsfaRepository;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsfaService {

    private RestTemplate restTemplate;
    private CsfaRepository repo;
    private Logger logger = LoggerFactory.getLogger(CsfaService.class);
//    logger.info("{}","works/%s".formatted(works));*/

    @Value("${alex.link1}")
    private String url1;

    @Value("${alex.weather.pass}")
    private String apiKey;
//    private String apiKey = System.getenv("OPENWEATHERAPP_KEY");

    public CsfaService(RestTemplate restTemplate, CsfaRepository repo) {
        this.restTemplate = restTemplate;
        this.repo = repo;
    }


//    Querying 3rd party api for json
   /* public List<Weather> getInfoFromApi(String country) {

        String url2 = UriComponentsBuilder
                .fromUriString(url1)
                .queryParam("q", country)
                .queryParam("appid", apiKey)
                .queryParam("mode", "metric")
                .toUriString();
        RequestEntity req = RequestEntity.get(url2).accept(MediaType.APPLICATION_JSON).build();

        ResponseEntity<String> resp = restTemplate.exchange(req, String.class);
        try (InputStream is = new ByteArrayInputStream(resp.getBody().getBytes())) {
            JsonReader reader = Json.createReader(is);
            JsonObject data = reader.readObject();

            JsonArray weather = data.getJsonArray("weather");
            String cityName = data.getString("name");
            double temp = data.getJsonObject("main").getJsonNumber("temp").doubleValue();
            List<Weather> weatherList = weather.stream()
                    .map(e -> (JsonObject)e)
                    .map(Weather::create)
                    .map(e -> {
                        e.setCityName(cityName);
                        e.setTemp(temp);
                        return e;
                    })
                    .collect(Collectors.toList());
            return weatherList;

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }*/


}
