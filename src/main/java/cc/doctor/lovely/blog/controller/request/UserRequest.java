package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class UserRequest extends AccessRequiredRequest {
    private Integer userId;

    private String username;
}
