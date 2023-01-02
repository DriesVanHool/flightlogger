package com.flightlogger.api.dtos

import java.time.LocalDateTime

class FlightDto(
    val id: Int,
    val departureTime: LocalDateTime?,
    val departureAirport: AirportDto,
    val arrivalTime: LocalDateTime,
    val arrivalAirport: AirportDto,
    val aircraft: AircraftDto,
    val remark: String
)