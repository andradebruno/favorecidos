package itau.favorecidos.sboot.resource.resource

import itau.favorecidos.application.exception.InvalidDocumentException
import itau.favorecidos.application.exception.NotFoundException
import itau.favorecidos.sboot.resource.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class FavoriteAccountExceptionHandler {

    @ExceptionHandler(value = [InvalidDocumentException::class])
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBadRequest(ex: Exception): ErrorResponse {
        return ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex?.message ?: "")
    }

    @ExceptionHandler(value = [NotFoundException::class])
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(ex: Exception): ErrorResponse {
        return ErrorResponse(HttpStatus.NOT_FOUND.value(), ex?.message ?: "")
    }
}