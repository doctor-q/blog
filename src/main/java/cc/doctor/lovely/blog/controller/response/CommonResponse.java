package cc.doctor.lovely.blog.controller.response;

import cc.doctor.lovely.blog.service.Errors;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResponse<T> implements Serializable {
    private static final long serialVersionUID = 6581335744278992744L;
    private boolean success;
    private Integer code;
    private String message;
    private T data;

    public static <T> CommonResponse<T> successResponse(T t) {
        CommonResponse<T> commonResponse = new CommonResponse<>();
        commonResponse.setSuccess(true);
        commonResponse.setData(t);
        return commonResponse;
    }

    public static CommonResponse failedResponse() {
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setSuccess(false);
        return commonResponse;
    }

    public static CommonResponse errorResponse(Errors errors) {
        CommonResponse commonResponse = failedResponse();
        commonResponse.setCode(errors.getCode());
        commonResponse.setMessage(errors.getMessage());
        return commonResponse;
    }

    public static CommonResponse errorResponse(Integer errorCode, String errorMessage) {
        CommonResponse commonResponse = failedResponse();
        commonResponse.setCode(errorCode);
        commonResponse.setMessage(errorMessage);
        return commonResponse;
    }

    public static CommonResponse accessDenyResponse() {
        return errorResponse(Errors.ACCESS_DENY);
    }

    public static CommonResponse tokenRequiredResponse() {
        return errorResponse(Errors.TOKEN_REQUIRED);
    }

    public static CommonResponse invalidParamResponse(String message) {
        CommonResponse failedResponse = failedResponse();
        failedResponse.setMessage(message);
        return failedResponse;
    }

    public static CommonResponse successResponse() {
        return successResponse(null);
    }
}
