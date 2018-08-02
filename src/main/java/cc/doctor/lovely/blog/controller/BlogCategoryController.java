package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.request.AddCategoryRequest;
import cc.doctor.lovely.blog.controller.request.DeleteCategoryRequest;
import cc.doctor.lovely.blog.controller.request.UserRequest;
import cc.doctor.lovely.blog.service.AuthService;
import cc.doctor.lovely.blog.service.BlogCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogCategoryController {
    @Autowired
    private AuthService authService;
    @Autowired
    private BlogCategoryService blogCategoryService;

    @RequestMapping("getBlogCategories")
    public Object getBlogCategories(UserRequest userRequest) {
        authService.setUserRequest(userRequest);
        return blogCategoryService.getBlogCategories(userRequest);
    }

    @RequestMapping("addCategory")
    public Object addCategory(AddCategoryRequest addCategoryRequest) {
        authService.setUserRequest(addCategoryRequest);
        return blogCategoryService.addCategory(addCategoryRequest);
    }

    @RequestMapping("deleteCategory")
    public Object deleteCategory(DeleteCategoryRequest deleteCategoryRequest) {
        authService.setUserRequest(deleteCategoryRequest);
        return blogCategoryService.deleteCategory(deleteCategoryRequest);
    }
}
