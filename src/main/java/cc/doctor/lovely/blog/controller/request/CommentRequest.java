package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class CommentRequest extends UserRequest {
    private Byte commentType;
    private Integer sourceId;
    private Integer commentRefId;
    private String comment;
}
