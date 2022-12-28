package com.flightlogger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlightloggerApplication

fun main(args: Array<String>) {
	runApplication<FlightloggerApplication>(*args)
}