package cc.doctor.lovely.blog.controller.filter;

import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.dao.model.Blogger;
import cc.doctor.lovely.blog.service.AuthService;
import cc.doctor.lovely.blog.service.jwt.JwtTokenService;
import cc.doctor.lovely.blog.utils.CookieUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import static com.google.common.net.HttpHeaders.X_REQUESTED_WITH;

@Component
@Slf4j
public class AuthFilter implements HandlerInterceptor {

    private static final String XML_HTTP_REQUEST = "XMLHttpRequest";

    @Autowired
    private JwtTokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return false;
        }
        //判断用户是否登录
        String accessToken = CookieUtils.getCookie("accessToken", request);
        if (accessToken == null || accessToken.isEmpty()) {
            return reLogin(request, response);
        }

        return true;
    }

    private Boolean reLogin(HttpServletRequest request,HttpServletResponse response) throws Exception{
        if(isAjax(request)) {
            CommonResponse response1 = CommonResponse.tokenRequiredResponse();
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(response1));
        }else{
            response.sendRedirect("/login");
        }
        return Boolean.FALSE;
    }

    private Boolean isAjax(HttpServletRequest request){
        if (request.getHeader(X_REQUESTED_WITH) != null && request.getHeader(X_REQUESTED_WITH).equalsIgnoreCase(XML_HTTP_REQUEST)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
