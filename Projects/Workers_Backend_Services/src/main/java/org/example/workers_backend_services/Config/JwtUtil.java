package org.example.workers_backend_services.Config;

import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtil {

    private static final String SECRET_KEY="dGhpc2lzYXNlY3JldGtleWZvcndvcmtlcnNkZW5hcHBsaWNhdGlvbg==";

    private static final long EXPIRATION_TIME = 1000 * 60 *60*10;

    private Key getSignKey(){
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String generate
}
