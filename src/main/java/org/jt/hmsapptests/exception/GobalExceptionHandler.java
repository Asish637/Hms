package org.jt.hmsapptests.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
public class GobalExceptionHandler extends ResponseEntityExceptionHandler {

    public ResponseEntity<ErrorDetails> resourceNotFountException(ResourceNotFoundException ex, WebRequest webRequest) {
        ErrorDetails error = new ErrorDetails(new Date(), ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
