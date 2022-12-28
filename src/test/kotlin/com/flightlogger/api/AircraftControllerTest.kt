package com.flightlogger

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AircraftControllerTest(var port: Int = 7000, @Autowired aircraftRepository: AircraftRepository) {

    @Test
    fun `Get All Aircrafts`() {
        val aircraft = Aircraft("test", "123", 1)
        aircraftRepository.save(aircraft)

        Given {
            port(port)
            contentType(MediaType.APPLICATION_JSON_VALUE)
        } When {
            get("/aircraft")
        } Then {
            statusCode(HttpStatus.SC_OK)
            log().all()
        }

    }
}