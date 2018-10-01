package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.service.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

// 全局异常处理
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public CommonResponse serviceExceptionHandler(HttpServletRequest req, Exception e) {
        ServiceException serviceException = (ServiceException) e;
        return CommonResponse.errorResponse(serviceException.getCode(), serviceException.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResponse defaultErrorHandler(HttpServletRequest req, Exception e) {
        log.error("", e);
        return CommonResponse.errorResponse(-1, e.getMessage());
    }
}
