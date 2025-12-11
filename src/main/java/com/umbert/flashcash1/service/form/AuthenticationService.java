package com.umbert.flashcash1.service.form;

import com.umbert.flashcash1.model.User;
import com.umbert.flashcash1.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s)throws UsernameNotFoundException {
        Optional<User> user = userRepository
                .findByEmail(s);
        if (user.isPresent()) {
            return new org.springframework.security.core.userdetails.User(user.get().getEmail(),
                    user.get().getPassword(), new ArrayList<>());
        }
        throw new UsernameNotFoundException("s");
    }
}
