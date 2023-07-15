package br.com.lucasmancan.controllers.handlers;

import br.com.lucasmancan.dtos.ApiError;
import br.com.lucasmancan.exceptions.ValidationException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {ValidationException.class, ExceptionHandler.class})
public class ValidationExceptionHandler implements ExceptionHandler<ValidationException, HttpResponse> {
    @Override
    public HttpResponse handle(HttpRequest request, ValidationException exception) {
        return HttpResponse.status(HttpStatus.BAD_REQUEST).body(ApiError.builder().message(exception.getMessage()).build());
    }
}
