package com.example.Employee_API.util;

import com.example.Employee_API.dto.loginResponse;
import com.example.Employee_API.entity.Employee;
import com.example.Employee_API.repository.EmpRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.example.Employee_API.security.SecurityConstants.EXPIRATION_TIME;

@Service
public class JWTUtil {
    private String secretKey = "inirahasia";
    Date now = new Date(System.currentTimeMillis());
    Date expiryDate = new Date(now.getTime()+EXPIRATION_TIME);
    @Autowired
    private EmpRepository userRepository;

    public loginResponse generateToken(String username) {
        Employee user = userRepository.findByUsername(username);
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        claims.put("name", user.getName());
        claims.put("position", user.getPosition());
        claims.put("password", user.getPassword());
        claims.put("id_employee", user.getId_employee());
        return createToken(claims, user.getUsername());
    }

    public loginResponse createToken(Map<String, Object> claims, String subject) {
        String token = Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();

        loginResponse response = new loginResponse();
        response.setToken(token);
        response.setStatus(200);
        response.setError(null);
        response.setMessage("Success");
        return response;
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }


    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
