package com.example.authentication.interfaces;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface IJwtUtil {
    public String extractUsername(String token);
    public Date extractExpiration(String token);
    public Claims extractClaims(String token);
    public<T> T extractClaim(String token, Function<Claims, T> claimResolver);
    public String generateToken(UserDetails userDetails);
    public String createToken(Map<String, Object> claims, String subject);
    public boolean validateToken(String token, UserDetails userDetails);
    public boolean isTokenExpired(String token);
}
