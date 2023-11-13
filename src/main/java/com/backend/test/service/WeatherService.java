package com.backend.test.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String WEATHER_API_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
    private static final String API_KEY = "{}"; // 발급받은 API 키

    public String getWeather(String base_date, String base_time, String nx, String ny) {
        String url = WEATHER_API_URL + "?serviceKey=" + API_KEY
                + "&dataType=JSON&numOfRows=10&pageNo=1&base_date=" + base_date
                + "&base_time=" + base_time + "&nx=" + nx + "&ny=" + ny;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
}
