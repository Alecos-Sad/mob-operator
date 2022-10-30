package by.sadovnick.moboperator.controller.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * Class describing the details of the exception
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionDetails {
    private Date timestamp;
    private String message;
    private String details;
    private HttpStatus httpStatus;
}
