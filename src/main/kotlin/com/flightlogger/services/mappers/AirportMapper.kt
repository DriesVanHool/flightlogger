package com.flightlogger.services.mappers

import com.flightlogger.api.dtos.AirportDto
import com.flightlogger.domain.Airport
import org.springframework.stereotype.Component

@Component
class AirportMapper {
    fun toDto(airport: Airport): AirportDto {
        return AirportDto(airport.id, airport.airportName, airport.icao, airport.iata)
    }

    fun toDto(airports: List<Airport>): List<AirportDto> {
        return airports.map { airport -> this.toDto(airport) }
    }
}