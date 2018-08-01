package cc.doctor.lovely.blog.controller.request;

import cc.doctor.lovely.blog.dao.model.BlogPostWithBLOBs;
import lombok.Data;

import java.util.List;

@Data
public class PostBlogRequest extends UserRequest {
    private Integer id;

    private Byte type = 0;

    private Byte status;

    private String title;

    private Integer category;

    private boolean allowComment = true;

    private boolean isPublic = true;

    private String summary;

    private String content;

    private List<String> tags;

    public BlogPostWithBLOBs toBlogWithBlobs() {
        return null;
    }
}
