package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class DeleteCommentRequest extends UserRequest {
    private Integer id;
}
