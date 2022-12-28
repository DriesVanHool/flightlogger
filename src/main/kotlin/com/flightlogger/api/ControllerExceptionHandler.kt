package com.flightlogger.api

import com.flightlogger.domain.exceptions.ErrorMessageModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ControllerExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [IllegalArgumentException::class, NoSuchElementException::class])
    fun handleArticleNotFoundException(ex: RuntimeException): ResponseEntity<ErrorMessageModel> {
        val errorMessage = ErrorMessageModel(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }
}