package org.lucidant.kotlinservice.controller.advice

import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ResponseStatusException


@RestControllerAdvice
class RestControllerAdvice {

    @ExceptionHandler(ResponseStatusException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handle(ex: RuntimeException): ResponseEntity<String?>? {
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
    }
}
