package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class DeleteUserRequest extends AccessRequiredRequest {
    private static final long serialVersionUID = -7639729010379204040L;

    private Integer id;
}
