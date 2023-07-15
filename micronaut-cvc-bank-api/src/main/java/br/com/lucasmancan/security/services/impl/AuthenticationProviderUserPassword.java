package br.com.lucasmancan.security.services.impl;

import br.com.lucasmancan.entities.Account;
import br.com.lucasmancan.repositories.AccountRepository;
import br.com.lucasmancan.security.models.AccountDetails;
import br.com.lucasmancan.services.PasswordEncoderService;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import lombok.AllArgsConstructor;

import javax.inject.Singleton;
import java.util.Optional;

@Singleton
@AllArgsConstructor
public class AuthenticationProviderUserPassword implements AuthenticationProvider {
    private final AccountRepository accountRepository;
    private final PasswordEncoderService encoderService;

    @Override
    public org.reactivestreams.Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {

        Optional<Account> account = accountRepository
                .findByDocument(authenticationRequest.getIdentity().toString());

        return Flowable.create(emitter -> {
            if (account.isPresent() && encoderService.equals(authenticationRequest.getSecret().toString(),
                    account.get().getPassword())) {
                emitter.onNext(new AccountDetails(account.get()));
                emitter.onComplete();
            } else {
                emitter.onError(new AuthenticationException(new AuthenticationFailed()));
            }
        }, BackpressureStrategy.ERROR);
    }
}