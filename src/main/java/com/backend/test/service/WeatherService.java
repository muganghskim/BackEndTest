package com.backend.test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
@Slf4j
@Service
public class WeatherService {

    private static final String WEATHER_API_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
    @Value("${go.data.apiKey}")
    private String API_KEY;

    public String getWeather(String base_date, String base_time, String nx, String ny) {
        try {
            String encodedKey = URLEncoder.encode(API_KEY, StandardCharsets.UTF_8.toString());

            String url = WEATHER_API_URL + "?ServiceKey=" + encodedKey + "&dataType=JSON&numOfRows=10&pageNo=1&base_date=" + base_date + "&base_time=" + base_time + "&nx=" + nx + "&ny=" + ny;

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getBody();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not supported", e);
        }
    }
}
