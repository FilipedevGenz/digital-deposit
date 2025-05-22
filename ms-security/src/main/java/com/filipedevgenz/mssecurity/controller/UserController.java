package com.filipedevgenz.mssecurity.controller;
import com.filipedevgenz.mssecurity.dto.AuthenticationDTO;
import com.filipedevgenz.mssecurity.dto.LoginResponseDTO;
import com.filipedevgenz.mssecurity.model.Users;
import com.filipedevgenz.mssecurity.service.TokenService;
import com.filipedevgenz.mssecurity.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RequestMapping("/security")
@RestController
public class UserController {
    private UserService userService;
    private TokenService tokenService;
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Users) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }




}
