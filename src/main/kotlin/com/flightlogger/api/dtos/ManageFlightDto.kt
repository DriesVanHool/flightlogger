package com.flightlogger.api.dtos

import jakarta.validation.constraints.*
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

class ManageFlightDto (
    @field:NotNull(message = "Missing departure time")
    val departureTime: LocalDateTime?,
    @field:PositiveOrZero(message = "Misssing departure airport")
    @field:NotNull(message = "Misssing departure airport")
    val departureAirportId: Int?,
    @field:NotNull(message = "Missing arrival time")
    val arrivalTime: LocalDateTime?,
    @field:PositiveOrZero(message = "Misssing arrival airport")
    @field:NotNull(message = "Misssing arrival airport")
    val arrivalAirportId: Int?,
    @field:PositiveOrZero(message = "Misssing aircraft")
    @field:NotNull(message = "Misssing aircraft")
    val aircraftId: Int?,
    val remark: String
)