package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class CommentRequest extends AccessRequiredRequest {
    private String comment;
}
