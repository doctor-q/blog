package cc.doctor.lovely.blog.controller.response;

import cc.doctor.lovely.blog.dao.model.BlogCategory;
import lombok.Data;

import java.util.List;

@Data
public class BlogCategoryResponse extends BlogCategory {
    private List<BlogCategory> children;
}
