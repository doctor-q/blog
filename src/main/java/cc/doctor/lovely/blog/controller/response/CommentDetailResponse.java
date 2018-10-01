package cc.doctor.lovely.blog.controller.response;

import cc.doctor.lovely.blog.dao.model.Comment;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

@Data
public class CommentDetailResponse {
    private Integer id;

    private String comment;

    private Byte commentType;

    private Integer sourceId;

    private Integer commentRefId;

    private Integer userId;

    private String username;

    private Date createdAt;

    private List<CommentDetailResponse> children;

    public CommentDetailResponse(Comment input) {
        BeanUtils.copyProperties(input, this);
    }
}
