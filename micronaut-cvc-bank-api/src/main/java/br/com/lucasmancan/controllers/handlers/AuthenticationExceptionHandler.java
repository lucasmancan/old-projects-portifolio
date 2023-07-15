package br.com.lucasmancan.controllers.handlers;

import br.com.lucasmancan.dtos.ApiError;
import br.com.lucasmancan.exceptions.AuthenticationException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {AuthenticationException.class, ExceptionHandler.class})
public class AuthenticationExceptionHandler implements ExceptionHandler<AuthenticationException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, AuthenticationException exception) {
        return HttpResponse.status(HttpStatus.UNAUTHORIZED).body(ApiError.builder().message("Authentication error.").build());
    }
}
