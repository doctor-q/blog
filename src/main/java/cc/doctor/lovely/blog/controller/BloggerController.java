package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.request.UpdateBloggerRequest;
import cc.doctor.lovely.blog.controller.request.UpdateContactRequest;
import cc.doctor.lovely.blog.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BloggerController {
    @Autowired
    private BloggerService bloggerService;

    @RequestMapping("addBlogger")
    public Object addBlogger() {
        return null;
    }

    @RequestMapping("updateBloggerInfo")
    public Object updateBloggerInfo(UpdateBloggerRequest updateBloggerRequest) {
        return bloggerService.updateBloggerInfo(updateBloggerRequest);
    }

    @RequestMapping("updateContacts")
    public Object updateContacts(UpdateContactRequest updateContactRequest) {
        return bloggerService.updateContacts(updateContactRequest);
    }
}
