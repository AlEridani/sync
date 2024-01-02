package home.server.syc.security;


import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import oracle.security.pki.ssl.ClassFileServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JwtTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
    private final String secretKey = "testkkkkkkk";

    public String createToken(String username) {
        logger.info("createToken");
        return Jwts.builder()
                .subject("auth")
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean isTokenValid(String Token) {
        logger.info("isTokenValid");
        try {
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
