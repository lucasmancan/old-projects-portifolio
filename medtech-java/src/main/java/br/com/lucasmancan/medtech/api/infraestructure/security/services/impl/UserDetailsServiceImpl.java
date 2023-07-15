package br.com.lucasmancan.medtech.api.infraestructure.security.services.impl;

import br.com.lucasmancan.medtech.api.domain.entities.User;
import br.com.lucasmancan.medtech.api.infraestructure.repositories.springData.UserRepositorySD;
import br.com.lucasmancan.medtech.api.infraestructure.security.models.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepositorySD repository;

    @Override
    public UserDetails loadUserByUsername(String s) {
        User user = repository.findByEmail(s).orElseThrow(() -> new UsernameNotFoundException("Invalid Credentials"));
        return new UserDetailsImpl(user);
    }
}
