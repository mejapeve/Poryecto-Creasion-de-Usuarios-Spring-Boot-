package com.bci.users.security;



import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;


@Service
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private String jwtExpirationMilliseconds;

    public String generateToken(String email){

        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + jwtExpirationMilliseconds);

        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

        return "Bearer "+token;
    }

    public String getUsernameFromJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody();

        return claims.getSubject();
    }

    public boolean validateToken (String token){
        try {
            Jwts.parser().setSigningKey(jwtSecret).build().parseClaimsJws(token);

            return true;

        }catch (SignatureException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Signature JWT no valid");
        }catch (MalformedJwtException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid JWT token");
        }catch (ExpiredJwtException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Expired JWT Token");
        }catch (UnsupportedJwtException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"JWT token not supported");
        }catch (IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"The Claims chain is empty");
        }

    }
}
