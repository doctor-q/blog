package cc.doctor.lovely.blog.controller.response;

import cc.doctor.lovely.blog.dao.model.BlogPostWithSummary;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class BlogListResponse {
    private Integer id;

    private Integer userId;

    private String username;

    private Byte type;

    private Byte status;

    private String title;

    private String summary;

    private Integer category;

    private Byte allowComment;

    private Byte isPublic;

    // 聚合层
    private Integer approvalNum;

    private Integer commentNum;

    private Integer readNum;

    private Date createdAt;

    public BlogListResponse(BlogPostWithSummary blogPost) {
        BeanUtils.copyProperties(blogPost, this);
    }

}
