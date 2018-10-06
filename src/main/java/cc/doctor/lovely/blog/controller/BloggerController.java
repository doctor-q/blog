package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.request.UpdateBloggerRequest;
import cc.doctor.lovely.blog.controller.request.UpdateContactRequest;
import cc.doctor.lovely.blog.controller.response.BloggerDetailResponse;
import cc.doctor.lovely.blog.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BloggerController {

    @Autowired
    private BloggerService bloggerService;

    @RequestMapping("settings/{id}")
    public Object settings(@PathVariable("id") Integer id, Model model) {
        BloggerDetailResponse bloggerDetailResponse = bloggerService.getBloggerDetail(id);
        model.addAttribute("blogger", bloggerDetailResponse);
        return "settings";
    }

    @RequestMapping("updateBloggerInfo")
    @ResponseBody
    public Object updateBloggerInfo(UpdateBloggerRequest updateBloggerRequest) {
        return bloggerService.updateBloggerInfo(updateBloggerRequest);
    }

    @RequestMapping("updateContacts")
    @ResponseBody
    public Object updateContacts(UpdateContactRequest updateContactRequest) {
        return bloggerService.updateContacts(updateContactRequest);
    }
}
