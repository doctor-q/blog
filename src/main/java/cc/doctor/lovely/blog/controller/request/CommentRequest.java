package cc.doctor.lovely.blog.controller.request;

import cc.doctor.lovely.blog.dao.model.Comment;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class CommentRequest extends UserRequest {
    private Byte commentType;
    private Integer sourceId;
    private Integer commentRefId;
    private String comment;

    public Comment toComment() {
        Comment comment = new Comment();
        BeanUtils.copyProperties(this, comment);
        return comment;
    }
}
