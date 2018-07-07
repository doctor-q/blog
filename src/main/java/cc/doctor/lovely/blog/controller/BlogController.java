package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.request.DeleteBlogRequest;
import cc.doctor.lovely.blog.controller.request.PostBlogRequest;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("blog")
public class BlogController {

    @RequestMapping("post")
    public CommonResponse post(PostBlogRequest postBlogRequest) {
        return null;
    }

    @RequestMapping("delete")
    public CommonResponse delete(DeleteBlogRequest deleteBlogRequest) {
        return null;
    }
}
