package com.filipedevgenz.msusers.controller;

import com.filipedevgenz.msusers.service.UserService;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
    UserService userService;


    @PatchMapping("/deposit/n/{num}/user/{userId}")
    public void addDeposit(@PathVariable int num, @PathVariable UUID userId) {
    userService.updateDepositQuantity(num,userId);
    }
}
