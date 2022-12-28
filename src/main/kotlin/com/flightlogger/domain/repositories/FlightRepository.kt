package com.flightlogger.domain.repositories

import com.flightlogger.domain.Flight
import org.springframework.data.jpa.repository.JpaRepository

interface FlightRepository : JpaRepository<Flight, Int> {
    fun findFlightById(id: Int): Flight?
}