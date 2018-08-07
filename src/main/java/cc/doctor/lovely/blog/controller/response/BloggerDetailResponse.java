package cc.doctor.lovely.blog.controller.response;

import cc.doctor.lovely.blog.dao.model.Attention;
import cc.doctor.lovely.blog.dao.model.Blogger;
import lombok.Data;

import java.util.List;

@Data
public class BloggerDetailResponse extends BloggerResponse {
    private Integer blogNum;
    private Integer blogAge;
    private Integer attentionNum;
    private List<Attention> attentions;
    private Integer followerNum;
    private List<Attention> followers;
    private List<BlogCategoryResponse> blogCategories;

    public BloggerDetailResponse() {
    }

    public BloggerDetailResponse(Blogger blogger) {
        super(blogger);
    }
}
