package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.request.DeleteBlogRequest;
import cc.doctor.lovely.blog.controller.request.PostBlogRequest;
import cc.doctor.lovely.blog.controller.response.BlogDetailResponse;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.service.AuthService;
import cc.doctor.lovely.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private AuthService authService;

    @Autowired
    private BlogService blogService;


    @RequestMapping("post")
    public CommonResponse post(PostBlogRequest postBlogRequest) {
        authService.setUserRequest(postBlogRequest);
        return blogService.post(postBlogRequest);
    }

    @RequestMapping("delete")
    public CommonResponse delete(DeleteBlogRequest deleteBlogRequest) {
        authService.setUserRequest(deleteBlogRequest);
        return blogService.delete(deleteBlogRequest);
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        BlogDetailResponse blogDetailResponse = blogService.getBlogDetail(id);
        model.addAttribute("blog", blogDetailResponse);
        return "editblog";
    }

    @RequestMapping("list")
    public String list() {
        return "profilebloglist";
    }

    @RequestMapping("detail")
    public String detail() {
        return "blogdetail";
    }
}
