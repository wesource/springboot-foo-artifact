package se.wesource.fooartifact.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import se.wesource.fooartifact.exception.CustomNotFoundException;
import se.wesource.fooartifact.model.ResponseError;

@RestControllerAdvice
public class ExceptionMapperAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseError handleNullpointer(NullPointerException ex) {
        ResponseError responseMsg = new ResponseError("NULLPOINTER: " + ex.getMessage());
        return responseMsg;
    }

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseError handleNotFoundException(CustomNotFoundException ex) {
        ResponseError responseMsg = new ResponseError("CUSTOM: " + ex.getMessage());
        return responseMsg;
    }
}
