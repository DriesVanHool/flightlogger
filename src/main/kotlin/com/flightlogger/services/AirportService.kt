package com.flightlogger.services

import com.flightlogger.api.dtos.AirportDto
import com.flightlogger.domain.repositories.AirportRepository
import com.flightlogger.services.mappers.AirportMapper
import org.springframework.stereotype.Service

@Service
class AirportService (val airportRepository: AirportRepository, val airportMapper: AirportMapper){
    fun getAllAirports(): List<AirportDto> {
        return airportMapper.toDto(airportRepository.findAll())
    }
}