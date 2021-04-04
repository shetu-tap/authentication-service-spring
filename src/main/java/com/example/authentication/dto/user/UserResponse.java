package com.example.authentication.dto.user;

import com.example.authentication.models.CustomUser;
import com.example.authentication.models.CustomUserDetails;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

@Data
public class UserResponse {
    private String Name;
    private String Username;
    private UUID Id;


    public UserResponse(CustomUser u) {
        this.setId(u.getId());
        this.setUsername(u.getUsername());
        this.setName(u.getName());
    }

    public UserResponse(CustomUserDetails u) {
        this.setId(u.getId());
        this.setUsername(u.getUsername());
        this.setName(u.getName());
    }
}
