package com.example.authentication.services;


import com.example.authentication.dto.registration.RegistrationBody;
import com.example.authentication.interfaces.IJwtUtil;
import com.example.authentication.interfaces.IUserService;
import com.example.authentication.models.CustomUser;
import com.example.authentication.models.CustomUserDetails;
import com.example.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    IJwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        CustomUser u = userRepository.findByUsername(s);
        return new CustomUserDetails(u);
    }

    @Override
    public CustomUser CreateUser(RegistrationBody registrationBody) {
        CustomUser u = new CustomUser(registrationBody);
        u.setPassword(passwordEncoder.encode(registrationBody.getPassword()));
        userRepository.save(u);
        return u;
    }

    @Override
    public void authenticateUser(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    username, password
            ));
        } catch (Exception e) {
            throw new Exception("Can not authenticate the user");
        }
    }

    @Override
    public String generateToken(String username) {
        UserDetails userDetails = this.loadUserByUsername(username);
        String token = jwtUtil.generateToken(userDetails);
        return token;
    }
}
