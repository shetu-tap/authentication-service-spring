package com.example.authentication.repository;

import com.example.authentication.models.CustomUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<CustomUser, UUID> {
    CustomUser findByUsername(String s);

}
