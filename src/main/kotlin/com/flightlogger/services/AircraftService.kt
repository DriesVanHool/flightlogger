package com.flightlogger.services

import com.flightlogger.api.dtos.AircraftDto
import com.flightlogger.domain.repositories.AircraftRepository
import com.flightlogger.services.mappers.AircraftMapper
import org.springframework.stereotype.Service

@Service
class AircraftService(val aircraftRepository: AircraftRepository, val aircraftMapper: AircraftMapper) {
    fun getAllAircraft(): List<AircraftDto> {
        return aircraftMapper.toDto(aircraftRepository.findAll())
    }


}