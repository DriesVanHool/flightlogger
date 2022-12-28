package com.flightlogger.api

import com.flightlogger.api.dtos.AircraftDto
import com.flightlogger.services.AircraftService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/aircraft")
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
class AircraftController(val aircraftService: AircraftService) {
    @GetMapping
    fun getAllAircraft(): List<AircraftDto>{
        return aircraftService.getAllAircraft()
    }
}