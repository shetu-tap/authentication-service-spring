package com.example.authentication.controllers;


import com.example.authentication.dto.login.LoginBody;
import com.example.authentication.dto.login.LoginResponse;
import com.example.authentication.dto.registration.RegistrationBody;
import com.example.authentication.dto.user.UserResponse;
import com.example.authentication.interfaces.IUserService;
import com.example.authentication.models.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    IUserService userService;

    @PostMapping("/register")
    public ResponseEntity CreateUser(@RequestBody RegistrationBody registrationBody) {
        CustomUser u = userService.CreateUser(registrationBody);
        return ResponseEntity.ok(new UserResponse(u));
    }


    @PostMapping("/login")
    public ResponseEntity LoginUser(@RequestBody LoginBody loginBody) throws Exception {
        userService.authenticateUser(loginBody.getUsername(), loginBody.getPassword());
        String token = userService.generateToken(loginBody.getUsername());
        return ResponseEntity.ok(new LoginResponse(token));
    }

}
