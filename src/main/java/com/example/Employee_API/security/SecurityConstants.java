package com.example.Employee_API.security;

public class SecurityConstants {
    public static final String HEADER_STRING = "Authorization";
    public static final String SECRET ="SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX= "Bearer ";
    public static final long EXPIRATION_TIME = 43_200_000; //12 hr
}
