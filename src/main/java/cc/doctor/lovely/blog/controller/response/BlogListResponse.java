package cc.doctor.lovely.blog.controller.response;

import lombok.Data;

import java.util.Date;

@Data
public class BlogListResponse {
    private String id;

    private Integer userId;

    private String username;

    private Byte type;

    private Byte status;

    private String title;

    private String summary;

    private Integer category;

    private Byte allowComment;

    private Byte isPublic;

    private Integer approvalNum;

    private Integer commentNum;

    private Integer readNum;

    private Date createdAt;

}
