package br.com.lucasmancan.math.exceptions;

import br.com.lucasmancan.math.models.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(AppExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    @ResponseBody
    protected ResponseEntity<AppResponse> handleException(Exception ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Internal server errror", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(AppResponse.OOPS);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    protected ResponseEntity<AppResponse> handleIllegalArgumentException(IllegalArgumentException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Illegal Argument error", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AppResponse("The request is not valid, check your operation type."));
    }

    @Override
    @ResponseBody
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }


        var response = new AppResponse("Argument validation failed.");
        response.setDetails(details);
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

}
