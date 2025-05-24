package com.filipedevgenz.mssecurity.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.filipedevgenz.mssecurity.config.TokenUtils;
import com.filipedevgenz.mssecurity.model.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    //todo
    @Value("${api.security.token.secret}")
    private String secretToken;

    public String generateToken(Users user) {
        Algorithm hashFuncion = Algorithm.HMAC256(secretToken);

        String token = JWT.create()
                .withIssuer("ms-security")
                .withSubject(user.getId().toString())
                .withExpiresAt(TokenUtils.getTokenDuration())
                .sign(hashFuncion);
        return token;
    }

    public String verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretToken);
        return JWT.require(algorithm)
                .withIssuer("ms-security")
                .build()
                .verify(token)
                .getSubject();
    }

}
