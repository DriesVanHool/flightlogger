package com.flightlogger.services.mappers

import com.flightlogger.api.dtos.AircraftDto
import com.flightlogger.domain.Aircraft
import org.springframework.stereotype.Component

@Component
class AircraftMapper {
    fun toDto(aircraft: Aircraft) : AircraftDto{
        return AircraftDto(aircraft.id, aircraft.registration, aircraft.type)
    }

    fun toDto(aircrafts: List<Aircraft>) : List<AircraftDto>{
        return aircrafts.map { aircraft -> this.toDto(aircraft) }
    }
}