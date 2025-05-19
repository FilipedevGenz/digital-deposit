package com.filipedevgenz.mssecurity.service;

import com.filipedevgenz.mssecurity.model.Users;
import com.filipedevgenz.mssecurity.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

  UsersRepository repositoryUsers;

    public void updateChanges(Users user) {
        repositoryUsers.save(user);
    }

    public Users findByUsername(String mail) {
        return repositoryUsers.findByEmailIgnoreCase(mail);
    }


}
