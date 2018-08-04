package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.controller.request.UpdateBloggerRequest;
import cc.doctor.lovely.blog.controller.request.UpdateContactRequest;
import cc.doctor.lovely.blog.controller.response.BloggerDetailResponse;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.dao.mapper.BloggerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloggerService {
    @Autowired
    private BloggerMapper bloggerMapper;


    private BloggerDetailResponse getBloggerDetail(Integer bloggerId) {
        return null;
    }

    public CommonResponse updateBloggerInfo(UpdateBloggerRequest updateBloggerRequest) {
        return null;
    }

    public CommonResponse updateContacts(UpdateContactRequest updateContactRequest) {
        return null;
    }
}
