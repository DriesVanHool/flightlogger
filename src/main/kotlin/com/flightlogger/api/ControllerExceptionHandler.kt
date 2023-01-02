package com.flightlogger.api

import com.flightlogger.domain.exceptions.ErrorMessageModel
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

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

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {

        val fieldErrors: List<FieldError> = ex.fieldErrors
        val errorMapping = fieldErrors.associate { it.field to it.defaultMessage }

        val errorDetails = ErrorDetails(
            timestamp = LocalDateTime.now(),
            message = "Validation Failed",
            details = errorMapping
        )
        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }
    data class ErrorDetails(val timestamp: LocalDateTime, val message: String, val details: Map<String, String?>)
}