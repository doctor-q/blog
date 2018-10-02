package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.request.UpdateBloggerRequest;
import cc.doctor.lovely.blog.controller.request.UpdateContactRequest;
import cc.doctor.lovely.blog.controller.response.BloggerDetailResponse;
import cc.doctor.lovely.blog.service.AuthService;
import cc.doctor.lovely.blog.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BloggerController {
    @Autowired
    private AuthService authService;

    @Autowired
    private BloggerService bloggerService;

    @RequestMapping("settings/{id}")
    public Object settings(@PathVariable("id") Integer id, Model model) {
        BloggerDetailResponse bloggerDetailResponse = bloggerService.getBloggerDetail(id);
        model.addAttribute("bloggerDetail", bloggerDetailResponse);
        return "settings";
    }

    @RequestMapping("updateBloggerInfo")
    public Object updateBloggerInfo(UpdateBloggerRequest updateBloggerRequest) {
        authService.setUserRequest(updateBloggerRequest);
        return bloggerService.updateBloggerInfo(updateBloggerRequest);
    }

    @RequestMapping("updateContacts")
    public Object updateContacts(UpdateContactRequest updateContactRequest) {
        authService.setUserRequest(updateContactRequest);
        return bloggerService.updateContacts(updateContactRequest);
    }
}
