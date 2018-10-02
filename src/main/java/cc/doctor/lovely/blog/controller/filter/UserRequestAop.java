package cc.doctor.lovely.blog.controller.filter;

import cc.doctor.lovely.blog.controller.request.UserRequest;
import cc.doctor.lovely.blog.dao.model.Blogger;
import cc.doctor.lovely.blog.service.ServiceException;
import cc.doctor.lovely.blog.service.jwt.JwtTokenService;
import cc.doctor.lovely.blog.utils.CookieUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class UserRequestAop {

    @Autowired
    private JwtTokenService tokenService;

    // 定义切入点
    @Pointcut("execution(public * cc.doctor.lovely.blog.controller.*.*(..))")
    public void setUser() {
        //
    }

    // 定义before切面
    @Before("setUser()")
    public void doBefore(JoinPoint joinPoint) throws ServiceException {

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                if (arg instanceof UserRequest) {
                    UserRequest userRequest = (UserRequest) arg;
                    String accessToken = CookieUtils.getCookie("accessToken", request);
                    if (accessToken != null) {
                        Blogger blogger = tokenService.getByToken(accessToken);
                        userRequest.setUserId(blogger.getId());
                        userRequest.setUsername(blogger.getUsername());
                    }
                }
            }
        }
    }

    // 定义after切面
    @AfterReturning(returning = "ret", pointcut = "setUser()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
    }
}
