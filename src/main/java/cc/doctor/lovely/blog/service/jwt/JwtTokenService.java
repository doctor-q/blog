package cc.doctor.lovely.blog.service.jwt;

import cc.doctor.lovely.blog.dao.model.Blogger;
import cc.doctor.lovely.blog.service.Errors;
import cc.doctor.lovely.blog.service.ServiceException;
import cc.doctor.lovely.blog.utils.DateUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

@Service
public class JwtTokenService {
    public static final Logger log = LoggerFactory.getLogger(JwtTokenService.class);

    @Autowired
    private Algorithm algorithm;

    public String generateAccountToken(Blogger blogger) {
        return JWT.create().withClaim(Claims.HEADER_CLAIM_USER_ID, blogger.getId())
                .withClaim(Claims.HEADER_CLAIM_USER_ID, blogger.getId())
                .withClaim(Claims.HEADER_CLAIM_USERNAME, blogger.getUsername())
                .withExpiresAt(DateUtils.timeAfter(DateUtils.ONE_DAY_MILLISECONDS))        //过期时间
                .sign(algorithm);
    }

    public Blogger getByToken(String accessToken) throws ServiceException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new ServiceException(Errors.TOKEN_REQUIRED);
        }
        try {
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(accessToken);
            Map<String, Claim> claims = decodedJWT.getClaims();
            Blogger blogger = new Blogger();
            Claim userId = claims.get(Claims.HEADER_CLAIM_USER_ID);
            if (userId == null) {
                throw new ServiceException(Errors.BAD_TOKEN);
            }
            blogger.setId(userId.as(Integer.class));
            Claim username = claims.get(Claims.HEADER_CLAIM_USERNAME);
            blogger.setUsername(username.asString());
            return blogger;
        } catch (TokenExpiredException tokenExpiredException) {
            throw new ServiceException(Errors.TOKEN_EXPIRE);
        } catch (JWTVerificationException e) {
            log.error("token解析异常", e);
            throw new ServiceException(Errors.BAD_TOKEN);
        }
    }
}
