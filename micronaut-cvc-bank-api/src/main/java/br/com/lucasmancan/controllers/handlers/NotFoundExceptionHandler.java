package br.com.lucasmancan.controllers.handlers;

import br.com.lucasmancan.dtos.ApiError;
import br.com.lucasmancan.exceptions.NotFoundException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {NotFoundException.class, ExceptionHandler.class})
public class NotFoundExceptionHandler implements ExceptionHandler<NotFoundException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, NotFoundException exception) {
        return HttpResponse.status(HttpStatus.NOT_FOUND).body(ApiError.builder().message("Resource not found").build());
    }
}
