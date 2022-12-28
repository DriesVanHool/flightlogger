package com.flightlogger.domain

import jakarta.persistence.*

@Entity
@Table(name = "airport")
class Airport(
    @Column(name = "airport_name")
    val airportName: String = "",

    @Column(name = "icao")
    val icao: String = "",

    @Column(name = "iata")
    val iata: String = "",

    @Column(name = "latitude")
    val latitude: String = "",

    @Column(name = "longitude")
    val longitude: String = "",

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airport_seq")
    @SequenceGenerator(name = "airport_seq", sequenceName = "airport_seq", allocationSize = 1)
    val id: Int = 0

)