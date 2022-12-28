package com.flightlogger.domain.repositories

import com.flightlogger.domain.Aircraft
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AircraftRepository : JpaRepository<Aircraft, Int> {
    fun findAircraftById(id:Int):Aircraft?
}