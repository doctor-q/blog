package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class BlogListRequest extends PageRequest {
    private Integer bloggerId;
    private String orderBy;
    private Integer category;
    private String tag;
}
