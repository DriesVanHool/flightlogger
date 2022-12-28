package com.flightlogger.services

import com.flightlogger.api.dtos.FlightDto
import com.flightlogger.api.dtos.ManageFlightDto
import com.flightlogger.domain.Flight
import com.flightlogger.domain.repositories.AircraftRepository
import com.flightlogger.domain.repositories.AirportRepository
import com.flightlogger.domain.repositories.FlightRepository
import com.flightlogger.services.mappers.FlightMapper
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import kotlin.IllegalArgumentException

@Service
@Transactional
class FlightService (val flightRepository: FlightRepository, val flightMapper: FlightMapper, val airportRepository: AirportRepository, val aircraftRepository: AircraftRepository){
    fun getAllFlights(): List<FlightDto> {
        return flightMapper.toDto(flightRepository.findAll())
    }

    fun addFlight(flight: ManageFlightDto): FlightDto {
        var newFlight = Flight(
            flight.departureTime,
            airportRepository.findAirportById(flight.departureAirportId)?:throw NoSuchElementException("Airport not found"),
            flight.arrivalTime,
            airportRepository.findAirportById(flight.arrivalAirportId)?:throw NoSuchElementException("Airport not found"),
            aircraftRepository.findAircraftById(flight.aircraftId)?:throw NoSuchElementException("Aircraft not found"),
            flight.remark
        )
        return flightMapper.toDto(flightRepository.save(newFlight))
    }

    fun removeFlight(id: String) {
        var flight = flightRepository.findFlightById(stringToInt(id))?:throw NoSuchElementException("Flight not found")
        flightRepository.delete(flight)
    }

    fun updateFlight(id: String, flightInput: ManageFlightDto) : FlightDto{
        var flight = flightRepository.findFlightById(stringToInt(id))?:throw NoSuchElementException("Flight not found")

        flight.departureTime = flightInput.departureTime
        flight.departureAirport = airportRepository.findAirportById(flightInput.departureAirportId)?:throw NoSuchElementException("Airport not found")
        flight.departureTime = flightInput.arrivalTime
        flight.arrivalAirport = airportRepository.findAirportById(flightInput.arrivalAirportId)?:throw NoSuchElementException("Airport not found")
        flight.aircraft = aircraftRepository.findAircraftById(flightInput.aircraftId)?:throw NoSuchElementException("Aircraft not found")
        flight.remark = flightInput.remark

        return flightMapper.toDto(flight);
    }

    fun stringToInt(value : String): Int{
        var myInt: Int
        try {
            myInt = value.toInt()
        }catch (ex : IllegalArgumentException){
            throw IllegalArgumentException("Incorrect value")
        }
        return myInt
    }
}