package com.flightlogger.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "flight")
class Flight(

    @Column(name = "departure_time")
    var departureTime: LocalDateTime? = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "departure_id")
    var departureAirport: Airport = Airport(),

    @Column(name = "arrival_time")
    var arrivalTime: LocalDateTime? = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "arrival_id")
    var arrivalAirport: Airport = Airport(),

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    var aircraft: Aircraft = Aircraft(),

    @Column
    var remark: String = "",

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_seq")
    @SequenceGenerator(name = "flight_seq", sequenceName = "flight_seq", allocationSize = 1)
    val id: Int = 0
)