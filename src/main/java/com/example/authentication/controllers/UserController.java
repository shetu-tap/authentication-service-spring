package com.example.authentication.controllers;

import com.example.authentication.dto.user.UserResponse;
import com.example.authentication.interfaces.IUserService;
import com.example.authentication.models.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/me")
    public ResponseEntity GetMeDetail(Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) userService.loadUserByUsername(authentication.getName());
        return ResponseEntity.ok(new UserResponse(userDetails));
    }
}
