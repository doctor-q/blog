package cc.doctor.lovely.blog.controller.response;

import lombok.Getter;

public enum Errors {
    TOKEN_EXPIRE(1000, "Token过期"),
    USERNAME_EXISTS(1001, "用户名已存在"),
    EMAIL_EXISTS(1002, "邮箱已存在"),
    PARAMETER_MISSING(1003, "参数缺失"),
    USERNAME_OR_PASSWORD_WRONG(1004, "用户名或密码错误"),
    ACCESS_DENY(1005, "权限不足"),
    TOKEN_REQUIRED(1006, "Token缺失"),
    USER_NOT_EXIST(1007, "用户不存在"),
    ROLE_EXISTS(1008, "角色名已存在"),
    OLD_EMAIL_WRONG(1009, "原始邮箱错误"),
    OLD_PASSWORD_WRONG(1010, "原始密码错误");

    @Getter
    private int code;
    @Getter
    private String message;

    Errors(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
