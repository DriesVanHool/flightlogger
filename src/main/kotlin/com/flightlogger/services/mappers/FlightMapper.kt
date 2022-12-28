package com.flightlogger.services.mappers

import com.flightlogger.api.dtos.FlightDto
import com.flightlogger.domain.Flight
import org.springframework.stereotype.Component

@Component
class FlightMapper(val airportMapper: AirportMapper, val aircraftMapper: AircraftMapper) {

    fun toDto(flight: Flight): FlightDto {
        return FlightDto(
            flight.id,
            flight.departureTime,
            airportMapper.toDto(flight.departureAirport),
            flight.arrivalTime,
            airportMapper.toDto(flight.arrivalAirport),
            aircraftMapper.toDto(flight.aircraft),
            flight.remark
        )
    }

    fun toDto(flights: List<Flight>): List<FlightDto> {
        return flights.map { flight ->  toDto(flight)}
    }
}