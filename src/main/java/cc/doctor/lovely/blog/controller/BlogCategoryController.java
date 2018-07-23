package cc.doctor.lovely.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogCategoryController {
    @RequestMapping("getBlogCategories")
    public Object getBlogCategories() {
        return null;
    }

    @RequestMapping("addCategory")
    public Object addCategory() {
        return null;
    }

    @RequestMapping("deleteCategory")
    public Object deleteCategory() {
        return null;
    }
}
