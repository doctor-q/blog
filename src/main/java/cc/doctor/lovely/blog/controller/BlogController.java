package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.request.BlogListRequest;
import cc.doctor.lovely.blog.controller.request.DeleteBlogRequest;
import cc.doctor.lovely.blog.controller.request.PostBlogRequest;
import cc.doctor.lovely.blog.controller.request.UserRequest;
import cc.doctor.lovely.blog.controller.response.BlogDetailResponse;
import cc.doctor.lovely.blog.controller.response.BlogListResponse;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.service.AuthService;
import cc.doctor.lovely.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @RequestMapping("add")
    public String add(UserRequest userRequest, Model model) {
        authService.setUserRequest(userRequest);
        return "editblog";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        BlogDetailResponse blogDetailResponse = blogService.getBlogDetail(id);
        model.addAttribute("blogDetail", blogDetailResponse);
        return "editblog";
    }

    @RequestMapping("list")
    public String list(BlogListRequest blogListRequest, Model model) {
        List<BlogListResponse> blogList = blogService.getBlogList(blogListRequest);
        model.addAttribute("blogList", blogList);
        return "profilebloglist";
    }

    @RequestMapping("detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        BlogDetailResponse blogDetail = blogService.getBlogDetail(id);
        model.addAttribute("blogDetail", blogDetail);
        return "blogdetail";
    }
}
