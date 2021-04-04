package com.example.authentication.models;

import com.example.authentication.dto.registration.RegistrationBody;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomUser {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID Id;
    private String username;
    private String name;
    private String password;


    public CustomUser(RegistrationBody registrationBody) {
        this.setName(registrationBody.getName());
        this.setUsername(registrationBody.getUsername());
    }
}
