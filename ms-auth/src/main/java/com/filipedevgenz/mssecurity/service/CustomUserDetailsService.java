package com.filipedevgenz.mssecurity.service;

import com.filipedevgenz.mssecurity.model.Users;
import com.filipedevgenz.mssecurity.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users loadedUser = usersRepository.findByEmailIgnoreCase(username);
        if (loadedUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return loadedUser;
    }
}
