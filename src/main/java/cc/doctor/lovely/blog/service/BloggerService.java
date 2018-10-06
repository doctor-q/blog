package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.controller.request.*;
import cc.doctor.lovely.blog.controller.response.BloggerDetailResponse;
import cc.doctor.lovely.blog.controller.response.BloggerResponse;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.dao.mapper.AttentionMapper;
import cc.doctor.lovely.blog.dao.mapper.BlogPostMapper;
import cc.doctor.lovely.blog.dao.mapper.BloggerMapper;
import cc.doctor.lovely.blog.dao.model.Attention;
import cc.doctor.lovely.blog.dao.model.Blogger;
import com.google.common.base.Preconditions;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BloggerService {
    @Autowired
    private BloggerMapper bloggerMapper;
    @Autowired
    private BlogPostMapper blogPostMapper;
    @Autowired
    private AttentionMapper attentionMapper;

    public BloggerResponse getBlogger(Integer bloggerId) {
        Preconditions.checkNotNull(bloggerId);

        Blogger blogger = bloggerMapper.selectByPrimaryKey(bloggerId);
        return new BloggerResponse(blogger);
    }

    public BloggerDetailResponse getBloggerDetail(Integer bloggerId) {
        Preconditions.checkNotNull(bloggerId);

        Blogger blogger = bloggerMapper.selectByPrimaryKey(bloggerId);
        BloggerDetailResponse bloggerDetailResponse = new BloggerDetailResponse(blogger);
        // 粉丝数
        int followerCount = attentionMapper.selectFollowerCount(bloggerId);
        bloggerDetailResponse.setFollowerNum(followerCount);
        List<Attention> followers = attentionMapper.selectFollowers(bloggerId);
        bloggerDetailResponse.setFollowers(followers);
        // 关注数
        int attentionCount = attentionMapper.selectAttentionCount(bloggerId);
        bloggerDetailResponse.setAttentionNum(attentionCount);
        List<Attention> attentions = attentionMapper.selectAttentions(bloggerId);
        bloggerDetailResponse.setAttentions(attentions);
        // 博客数
        int blogNum = blogPostMapper.selectBlogCount(bloggerId);
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
        Preconditions.checkNotNull(updateBloggerRequest.getId());

        Blogger blogger = updateBloggerRequest.toBlogger();
        bloggerMapper.updateByPrimaryKeySelective(blogger);
        return CommonResponse.successResponse(null);
    }

    public CommonResponse updateContacts(UpdateContactRequest updateContactRequest) {
        Preconditions.checkNotNull(updateContactRequest.getId());

        Blogger blogger = updateContactRequest.toBlogger();
        bloggerMapper.updateByPrimaryKeySelective(blogger);
        return CommonResponse.successResponse(null);
    }

    public List<BloggerResponse> getSuggestBloggers() {
        List<Blogger> bloggers = bloggerMapper.selectPage(new RowBounds());
        return bloggers.stream().map(input -> new BloggerResponse(input)).collect(Collectors.toList());
    }

    public Blogger getBloggerByPassword(String username, String password) {
        Preconditions.checkNotNull(username);
        Preconditions.checkNotNull(password);

        return bloggerMapper.selectByPassword(username, password);
    }

    public CommonResponse register(RegisterRequest registerRequest) {
        Preconditions.checkNotNull(registerRequest);
        Preconditions.checkNotNull(registerRequest.getEmail());
        Preconditions.checkNotNull(registerRequest.getUsername());
        Preconditions.checkNotNull(registerRequest.getPassword());

        Blogger blogger = registerRequest.toBlogger();
        if (blogger.getHeader() == null) {
            blogger.setHeader("/assets/images/avatars/avatars.png");
        }
        bloggerMapper.insertSelective(blogger);
        return CommonResponse.successResponse(blogger.getId());
    }
}
