package com.flightlogger.api

import com.flightlogger.api.dtos.FlightDto
import com.flightlogger.api.dtos.ManageFlightDto
import com.flightlogger.services.FlightService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/flight")
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
class FlightController(val fLightService: FlightService) {
    @GetMapping
    fun getAllFlights(): List<FlightDto> {
        return fLightService.getAllFlights()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addFlight(@RequestBody flight: ManageFlightDto): FlightDto {
        return fLightService.addFlight(flight)
    }

    @DeleteMapping("/{id}")
    fun removeFlight(@PathVariable(value = "id") id: String) {
        fLightService.removeFlight(id)
    }

    @PutMapping("/{id}")
    fun updateFlight(@PathVariable(value = "id") id: String, @RequestBody flight: ManageFlightDto): FlightDto{
        return fLightService.updateFlight(id, flight)
    }

}