package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.controller.response.Errors;
import cc.doctor.lovely.blog.dao.model.User;
import cc.doctor.lovely.blog.service.UserService;
import cc.doctor.lovely.blog.service.jwt.Claims;
import cc.doctor.lovely.blog.utils.DateUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private Algorithm algorithm;

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public CommonResponse login(String username, String password) {
        User user = userService.getUserByUsernameAndPassword(username, password);
        if (user == null) {
            return CommonResponse.errorResponse(Errors.USERNAME_OR_PASSWORD_WRONG);
        }
        Map<String, Object> map = new HashMap<>();
        map.put(Claims.HEADER_CLAIM_USER_ID, user.getId());
        map.put(Claims.HEADER_CLAIM_USERNAME, user.getUsername());
        String token = JWT.create().withHeader(map)
                .withExpiresAt(DateUtils.timeAfter(DateUtils.ONE_DAY_MILLISECONDS))        //过期时间
                .sign(algorithm);
        return CommonResponse.successResponse(token);
    }

    @RequestMapping("/logout")
    public CommonResponse<String> logout() {
        return CommonResponse.successResponse("success");
    }
}
