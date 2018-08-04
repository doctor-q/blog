package cc.doctor.lovely.blog.controller.response;

import cc.doctor.lovely.blog.dao.model.Blogger;
import lombok.Data;

import java.util.List;

@Data
public class BloggerDetailResponse extends BloggerResponse {
    private List<Blogger> attentions;
    private List<Blogger> followers;
    private List<BlogCategoryResponse> blogCategories;
}
