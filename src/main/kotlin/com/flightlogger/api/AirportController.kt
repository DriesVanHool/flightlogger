package com.flightlogger.api

import com.flightlogger.api.dtos.AirportDto
import com.flightlogger.services.AirportService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/airport")
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
class AirportController (val airportService: AirportService){

    @GetMapping
    fun getAllAirports(): List<AirportDto>{
        return airportService.getAllAirports();
    }
}