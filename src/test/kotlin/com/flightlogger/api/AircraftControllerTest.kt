package com.flightlogger

import com.flightlogger.domain.Aircraft
import com.flightlogger.domain.repositories.AircraftRepository
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AircraftControllerTest() {
    @LocalServerPort
    var port: Int = 7000


    @Test
    fun `Get All Aircrafts`() {

        Given {
            port(port)
            contentType(MediaType.APPLICATION_JSON_VALUE)
        } When {
            get("/aircraft")
        } Then {
                        log().all()
        }

    }
}