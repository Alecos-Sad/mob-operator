package by.sadovnick.moboperator.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class on not correct data input
 */
@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
@Getter
public class NotCorrectException extends RuntimeException{

   public NotCorrectException(String message) {
        super(message);
    }
}
