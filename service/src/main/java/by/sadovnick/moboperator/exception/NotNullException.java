package by.sadovnick.moboperator.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class for not Null input data
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
@Getter
public class NotNullException extends RuntimeException {
    public NotNullException(String message) {
        super(message);
    }
}

