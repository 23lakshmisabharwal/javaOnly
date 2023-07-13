package com.exittest.backend.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
/**
 * Utility class for JWT (JSON Web Token) operations.
 */
@Component
public class JwtUtils {
	private String SECRET_KEY = "secret";
	/**
	 * Extracts the username from the JWT token.
	 *
	 * @param token The JWT token.
	 * @return The username extracted from the token.
	 */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    
    /**
	 * Extracts the expiration date from the JWT token.
	 *
	 * @param token The JWT token.
	 * @return The expiration date extracted from the token.
	 */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

	/**
	 * Extracts a claim from the JWT token.
	 *
	 * @param token The JWT token.
	 * @param claimsResolver The function to resolve the desired claim from the token.
	 * @param <T> The type of the claim.
	 * @return The claim value extracted from the token.
	 */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
	/**
	 * Generates a JWT token for the specified user details.
	 *
	 * @param userDetails The user details for whom the token is generated.
	 * @return The generated JWT token.
	 */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }
	/**
	 * Validates a JWT token for the specified user details.
	 *
	 * @param token The JWT token to validate.
	 * @param userDetails The user details to validate against.
	 * @return `true` if the token is valid, `false` otherwise.
	 */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
