package br.com.lucasmancan.medtech.api.infraestructure.controllers;

import br.com.lucasmancan.medtech.api.domain.dto.ApiResponse;
import br.com.lucasmancan.medtech.api.domain.exceptions.NotFoundException;
import br.com.lucasmancan.medtech.api.infraestructure.security.exceptions.PasswordDoenstMatchException;
import br.com.lucasmancan.medtech.api.infraestructure.security.exceptions.UserAlreadyExistsException;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        String message = String.format("O parâmetro '%s' deve ser do tipo '%s'.", e.getName(), e.getRequiredType().getSimpleName());
        ApiResponse apiResponse = ApiResponse.builder().message(message).status(400).build();
        return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UserAlreadyExistsException.class, PasswordDoenstMatchException.class})
    @ResponseBody
    public final ResponseEntity<ApiResponse> handleAllCustomBadRequestException(RuntimeException ex, WebRequest request) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(ex.getMessage());
        apiResponse.setStatus(400);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public final ResponseEntity<ApiResponse> handleUserNotFoundException(NotFoundException ex, WebRequest request) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(ex.getMessage());
        apiResponse.setStatus(404);

        log.log(Level.ERROR, ex.getMessage(), ex);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({AuthenticationException.class})
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseEntity<ApiResponse> handleAuthenticationException(Exception ex) {

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(ex.getMessage());
        apiResponse.setStatus(401);

        return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
    }

    @Override
    @ResponseBody
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Erro na validação dos campos.");
        apiResponse.setErrors(details);
        apiResponse.setStatus(400);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

}