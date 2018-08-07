package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.controller.request.AddBloggerRequest;
import cc.doctor.lovely.blog.controller.request.UpdateBloggerRequest;
import cc.doctor.lovely.blog.controller.request.UpdateContactRequest;
import cc.doctor.lovely.blog.controller.request.UserRequest;
import cc.doctor.lovely.blog.controller.response.BloggerDetailResponse;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.dao.mapper.AttentionMapper;
import cc.doctor.lovely.blog.dao.mapper.BlogPostMapper;
import cc.doctor.lovely.blog.dao.mapper.BloggerMapper;
import cc.doctor.lovely.blog.dao.model.Attention;
import cc.doctor.lovely.blog.dao.model.Blogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class BloggerService {
    @Autowired
    private BloggerMapper bloggerMapper;
    @Autowired
    private BlogPostMapper blogPostMapper;
    @Autowired
    private AttentionMapper attentionMapper;

    public BloggerDetailResponse getBloggerDetail(UserRequest userRequest) {
        Blogger blogger = bloggerMapper.selectByUserId(userRequest.getUserId());
        BloggerDetailResponse bloggerDetailResponse = new BloggerDetailResponse(blogger);
        // 粉丝数
        int followerCount = attentionMapper.selectFollowerCount(blogger.getId());
        bloggerDetailResponse.setFollowerNum(followerCount);
        List<Attention> followers = attentionMapper.selectFollowers(blogger.getId());
        bloggerDetailResponse.setFollowers(followers);
        // 关注数
        int attentionCount = attentionMapper.selectAttentionCount(blogger.getId());
        bloggerDetailResponse.setAttentionNum(attentionCount);
        List<Attention> attentions = attentionMapper.selectAttentions(blogger.getId());
        bloggerDetailResponse.setAttentions(attentions);
        // 博客数
        int blogNum = blogPostMapper.selectBloggerCount(userRequest.getUserId());
        bloggerDetailResponse.setBlogNum(blogNum);
        // 博龄
        int current = Calendar.getInstance().get(Calendar.YEAR);
        Calendar instance = Calendar.getInstance();
        instance.setTime(blogger.getCreatedAt());
        int blogAge = current - instance.get(Calendar.YEAR);
        bloggerDetailResponse.setBlogAge(blogAge);
        // 博客分类
        return bloggerDetailResponse;
    }

    public CommonResponse updateBloggerInfo(UpdateBloggerRequest updateBloggerRequest) {
        Blogger blogger = updateBloggerRequest.toBlogger();
        bloggerMapper.updateByPrimaryKeySelective(blogger);
        return CommonResponse.successResponse(null);
    }

    public CommonResponse updateContacts(UpdateContactRequest updateContactRequest) {
        Blogger blogger = updateContactRequest.toBlogger();
        bloggerMapper.updateByPrimaryKeySelective(blogger);
        return CommonResponse.successResponse(null);
    }

    public CommonResponse addBlogger(AddBloggerRequest addBloggerRequest) {
        return null;
    }
}
