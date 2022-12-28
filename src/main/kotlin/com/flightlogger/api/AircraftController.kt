package com.flightlogger.api

import com.flightlogger.api.dtos.AircraftDto
import com.flightlogger.domain.Aircraft
import com.flightlogger.services.AircraftService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/aircraft")
class AircraftController(val aircraftService: AircraftService) {
    @GetMapping
    fun getAllAircraft(): List<AircraftDto>{
        return aircraftService.getAllAircraft()
    }
}