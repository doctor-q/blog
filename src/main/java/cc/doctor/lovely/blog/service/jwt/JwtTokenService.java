package cc.doctor.lovely.blog.service.jwt;

import cc.doctor.lovely.blog.dao.model.User;
import cc.doctor.lovely.blog.utils.DateUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
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

    public String generateAccountToken(User user) {
        return JWT.create().withClaim(Claims.HEADER_CLAIM_USER_ID, user.getId())
                .withClaim(Claims.HEADER_CLAIM_USERNAME, user.getUsername())
                .withExpiresAt(DateUtils.timeAfter(DateUtils.ONE_DAY_MILLISECONDS))        //过期时间
                .sign(algorithm);
    }

    public User getAccountByToken(String accessToken) {
        if(StringUtils.isEmpty(accessToken)){
            log.info("token为空，请重新登录");
            return null;
        }
        try {
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(accessToken);
            Map<String, Claim> claims = decodedJWT.getClaims();
            User disAccount = new User();
            Claim userId = claims.get(Claims.HEADER_CLAIM_USER_ID);
            if (userId == null) {
                return null;
            }
            disAccount.setId(userId.as(Integer.class));
            Claim username = claims.get(Claims.HEADER_CLAIM_USERNAME);
            disAccount.setUsername(username.asString());
            return disAccount;
        } catch (IllegalArgumentException e) {
            log.error("", e);
        }catch (JWTVerificationException e){
            log.error("token解析异常",e);
            throw e;
        }
        return null;
    }
}
