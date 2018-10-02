package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.request.RegisterRequest;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.dao.model.Blogger;
import cc.doctor.lovely.blog.service.BloggerService;
import cc.doctor.lovely.blog.service.Errors;
import cc.doctor.lovely.blog.service.jwt.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private BloggerService bloggerService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @RequestMapping("signIn")
    public String signIn() {
        return "login";
    }

    @RequestMapping("signUp")
    @ResponseBody
    public Object signUp(RegisterRequest registerRequest) {
        return bloggerService.register(registerRequest);
    }


    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("doLogin")
    @ResponseBody
    public CommonResponse doLogin(String username, String password) {
        Blogger blogger = bloggerService.getBloggerByPassword(username, password);
        if (blogger == null) {
            return CommonResponse.errorResponse(Errors.USERNAME_OR_PASSWORD_WRONG);
        }
        String token = jwtTokenService.generateAccountToken(blogger);
        return CommonResponse.successResponse(token);
    }

    @RequestMapping("/logout")
    public CommonResponse<String> logout() {
        return CommonResponse.successResponse("success");
    }
}
