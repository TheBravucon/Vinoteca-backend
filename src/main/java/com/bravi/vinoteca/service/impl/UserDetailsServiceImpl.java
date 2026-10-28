package com.bravi.vinoteca.service.impl;

import com.bravi.vinoteca.config.UserDetailsEx;
import com.bravi.vinoteca.entity.User;
import com.bravi.vinoteca.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userFound = userRepository.findByEmail(username);

        if (userFound.isEmpty())
            throw new UsernameNotFoundException(username);

        return new UserDetailsEx(userFound.get());
    }
}
