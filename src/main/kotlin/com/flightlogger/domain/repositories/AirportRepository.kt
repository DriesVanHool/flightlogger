package com.flightlogger.domain.repositories

import com.flightlogger.domain.Airport
import org.springframework.data.jpa.repository.JpaRepository

interface AirportRepository : JpaRepository<Airport, Int> {
    fun findAirportById(id:Int?):Airport?
}