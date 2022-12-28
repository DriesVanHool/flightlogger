package com.flightlogger.domain

import jakarta.persistence.*

@Entity
@Table(name = "aircraft")
class Aircraft(
    @Column(name = "registration")
    val registration: String="",

    @Column(name = "aircraft_type")
    val type: String="",

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aircraft_seq")
    @SequenceGenerator(name = "aircraft_seq", sequenceName = "aircraft_seq", allocationSize = 1)
    val id: Int = 0
)