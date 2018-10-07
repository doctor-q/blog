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
import cc.doctor.lovely.blog.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private AuthService authService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private BloggerService bloggerService;


    @RequestMapping("post")
    @ResponseBody
    public CommonResponse post(PostBlogRequest postBlogRequest) {
        return blogService.post(postBlogRequest);
    }

    @RequestMapping("delete")
    @ResponseBody
    public CommonResponse delete(DeleteBlogRequest deleteBlogRequest) {
        authService.setUserRequest(deleteBlogRequest);
        return blogService.delete(deleteBlogRequest);
    }

    @RequestMapping("add")
    public String add() {
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
        model.addAttribute("blogger", bloggerService.getBloggerDetail(blogListRequest.getBloggerId()));
        return "profilebloglist";
    }

    @RequestMapping("{id}")
    public String blog(@PathVariable("id") Integer id, Model model) {
        BlogDetailResponse blogDetail = blogService.getBlogDetail(id);
        model.addAttribute("blogDetail", blogDetail);
        return "blogdetail";
    }

    @RequestMapping("detail/{id}")
    @ResponseBody
    public Object detail(@PathVariable("id") Integer id) {
        BlogDetailResponse blogDetail = blogService.getBlogDetail(id);
        return CommonResponse.successResponse(blogDetail);
    }
}
