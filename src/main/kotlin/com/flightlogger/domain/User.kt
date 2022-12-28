package com.flightlogger.domain

import jakarta.persistence.*

@Entity
@Table(name = "member")
class User(
    @Column(name = "firstname")
    val firstname: String = "",

    @Column(name = "lastname")
    val lastname: String = "",

    @Column(name = "email")
    val email: String = "",

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    @SequenceGenerator(name = "member_seq", sequenceName = "member_seq", allocationSize = 1)
    val id: Int = 0

)
