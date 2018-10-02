package cc.doctor.lovely.blog.service.jwt;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;

@Configuration
public class JwtConfig {
    public static final String SECRET = "123456";

    @Bean
    public Algorithm algorithm() {
        try {
            return Algorithm.HMAC256(SECRET);
        } catch (UnsupportedEncodingException e) {

        }
        return null;
    }
}
