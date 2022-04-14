package nl.novi.techiteasy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class RecordNotFoundException extends RuntimeException{
    /*
    [v] een default exception
    [v] een exception met message
    */

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
    }

}

