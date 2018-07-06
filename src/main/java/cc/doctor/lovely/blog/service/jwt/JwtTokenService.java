package cc.doctor.lovely.blog.service.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cantang.yimi.wx.mp.dao.model.DisAccount;
import com.cantang.yimi.wx.mp.service.Claims;
import com.cantang.yimi.wx.mp.utils.DateUtils;
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

    public String generateAccountToken(DisAccount account) {
        return JWT.create().withClaim(Claims.HEADER_CLAIM_ACCOUNT_ID, account.getId())
                .withClaim(Claims.HEADER_CLAIM_ACCOUNT_NAME, account.getAccountName())
                .withExpiresAt(DateUtils.timeAfter(DateUtils.ONE_DAY_MILLISECONDS))        //过期时间
                .sign(algorithm);
    }

    public DisAccount getAccountByToken(String accessToken) {
        if(StringUtils.isEmpty(accessToken)){
            log.info("token为空，请重新登录");
            return null;
        }
        try {
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(accessToken);
            Map<String, Claim> claims = decodedJWT.getClaims();
            DisAccount disAccount = new DisAccount();
            Claim accountId = claims.get(Claims.HEADER_CLAIM_ACCOUNT_ID);
            if (accountId == null) {
                return null;
            }
            disAccount.setId(accountId.as(Integer.class));
            Claim accountName = claims.get(Claims.HEADER_CLAIM_ACCOUNT_NAME);
            disAccount.setAccountName(accountName.asString());
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
