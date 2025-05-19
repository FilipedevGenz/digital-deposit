package com.filipedevgenz.msusers.service;

import com.filipedevgenz.msusers.UserRepository;
import com.filipedevgenz.msusers.exceptions.UserNotFound;
import com.filipedevgenz.msusers.model.Users;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
@AllArgsConstructor
@Service
public class UserService {
    UserRepository userRepository;
    PasswordEncoder encoder;

    public void updateDepositQuantity(int num, UUID userId) {
        Users toUpdate = userRepository.findById(userId).orElseThrow(() -> new UserNotFound("User not found"));
        int numToUpdate = toUpdate.getNumOfDeposits() + num;
        toUpdate.setNumOfDeposits(numToUpdate);
        userRepository.save(toUpdate);
    }

    public void saveUsers(Users users) {
        var password = users.getPassword();
        users.setPassword(encoder.encode(users.getPassword()));
        userRepository.save(users);
    }
}
