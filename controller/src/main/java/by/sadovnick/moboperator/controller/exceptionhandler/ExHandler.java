package by.sadovnick.moboperator.controller.exceptionhandler;

import by.sadovnick.moboperator.exception.NotNullException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.Date;

/**
 * Class that catches exceptions for the given controller
 */
@RestControllerAdvice
@Log4j2
public class ExHandler {
    /**
     * Catches exception {@link NotNullException}
     * @param notNullException exception {@link NotNullException}
     * @return {@link ExceptionDetails}
     */
    @ExceptionHandler(NotNullException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionDetails handlerEntityIsNotCorrect(NotNullException notNullException) {
        log.error("Bad input value");
        return ExceptionDetails.builder()
                .timestamp(Date.from(Instant.now()))
                .message(notNullException.getMessage())
                .httpStatus(HttpStatus.CONFLICT)
                .details("BAD INPUT VALUE")
                .build();
    }

    /**
     * Catches exception {@link EntityNotFoundException}
     * @param entityNotFoundException {@link EntityNotFoundException}
     * @return {@link ExceptionDetails}
     */
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDetails handlerEntityNotFound(EntityNotFoundException entityNotFoundException) {
        log.error("Not found entity by id");
        return ExceptionDetails.builder()
                .timestamp(Date.from(Instant.now()))
                .message(entityNotFoundException.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .details("Not found entity by ID!")
                .build();
    }
}