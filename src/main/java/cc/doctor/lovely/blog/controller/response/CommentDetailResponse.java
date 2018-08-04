package cc.doctor.lovely.blog.controller.response;

import lombok.Data;

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

    private Date createdAt;

    private List<CommentDetailResponse> children;
}
