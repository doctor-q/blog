package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class BlogListRequest extends PageRequest {
    private String userId;
    private String orderBy;
    private Integer category;
    private String tag;
}
