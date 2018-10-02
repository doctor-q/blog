package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.request.BlogListRequest;
import cc.doctor.lovely.blog.controller.response.BlogListResponse;
import cc.doctor.lovely.blog.controller.response.BloggerResponse;
import cc.doctor.lovely.blog.service.BlogService;
import cc.doctor.lovely.blog.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BloggerService bloggerService;

    @RequestMapping("/")
    public String index(BlogListRequest blogListRequest, Model model) {
        List<BloggerResponse> bloggerResponses = bloggerService.getSuggestBloggers();
        model.addAttribute("bloggerList", bloggerResponses);
        List<BlogListResponse> blogList = blogService.getBlogList(blogListRequest);
        model.addAttribute("blogList", blogList);
        return "index";
    }
}
