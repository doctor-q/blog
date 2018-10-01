package cc.doctor.lovely.blog.controller.response;

import lombok.Data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
public class BlogDetailResponse {
    private Integer id;

    private Integer userId;

    private String username;

    private Byte type;

    private Byte status;

    private String title;

    private String summary;

    private String content;

    private Integer category;

    private Byte allowComment;

    private Byte isPublic;

    private Integer approvalNum;

    private Integer commentNum;

    private Integer readNum;

    private Date createdAt;

    private List<CommentDetailResponse> commentDetails = new LinkedList<>();
}
