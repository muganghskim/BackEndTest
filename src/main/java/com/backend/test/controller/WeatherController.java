package com.backend.test.controller;

import com.backend.test.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@Api(value = "Weather Controller", description = "날씨 정보를 조회하는 API")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    @ApiOperation(value = "날씨 정보 조회", notes = "특정 날짜, 시간, 좌표에 대한 날씨 정보를 조회합니다.")
    public ResponseEntity<String> getWeather(
            @ApiParam(value = "조회하려는 날짜", required = true) @RequestParam String base_date,
            @ApiParam(value = "조회하려는 시간", required = true) @RequestParam String base_time,
            @ApiParam(value = "조회하려는 위치의 x좌표", required = true) @RequestParam String nx,
            @ApiParam(value = "조회하려는 위치의 y좌표", required = true) @RequestParam String ny) {
        String weather = weatherService.getWeather(base_date, base_time, nx, ny);
        return ResponseEntity.ok(weather);
    }
}
