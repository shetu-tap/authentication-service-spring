package com.example.authentication.interfaces;

import com.example.authentication.dto.registration.RegistrationBody;
import com.example.authentication.models.CustomUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    CustomUser CreateUser(RegistrationBody registrationBody);
    void authenticateUser(String username, String password) throws Exception;
    String generateToken(String username);
}
