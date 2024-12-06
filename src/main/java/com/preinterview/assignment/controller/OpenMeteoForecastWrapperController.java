package com.preinterview.assignment.controller;
import com.preinterview.assignment.service.OpenmeteoforecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OpenMeteoForecastWrapperController {
    @Autowired
    private OpenmeteoforecastService  openmeteoforecastService;

    @GetMapping("/weather")
    public @ResponseBody Object getTemprature(@RequestParam double latitude, @RequestParam double longitude) {
        return  openmeteoforecastService.getTemparature(latitude,longitude);
    }


}
