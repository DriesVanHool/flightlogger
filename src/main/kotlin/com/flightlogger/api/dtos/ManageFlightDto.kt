package com.flightlogger.api.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PositiveOrZero
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

class ManageFlightDto (
    @NotEmpty(message = "Missing departure time")
    val departureTime: LocalDateTime,
    @PositiveOrZero(message = "Misssing departure airport")
    val departureAirportId: Int,
    val arrivalTime: LocalDateTime,
    val arrivalAirportId: Int,
    @PositiveOrZero(message = "Misssing aircraft")
    val aircraftId: Int,
    val remark: String
)