package cc.doctor.lovely.blog.controller.filter;

import cc.doctor.lovely.blog.dao.model.Blogger;
import cc.doctor.lovely.blog.service.jwt.JwtTokenService;
import cc.doctor.lovely.blog.utils.CookieUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoggedInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtTokenService tokenService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null) {
            return;
        }
        //判断用户是否登录
        String accessToken = CookieUtils.getCookie("accessToken", request);
        if (accessToken != null && !accessToken.isEmpty()) {
            try {
                Blogger blogger = tokenService.getByToken(accessToken);
                modelAndView.getModel().put("profile", blogger);
            } catch (Exception e) {
                log.warn("", e);
            }
        }
    }
}
