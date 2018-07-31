package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.controller.request.DeleteBlogRequest;
import cc.doctor.lovely.blog.controller.request.PostBlogRequest;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.controller.response.Errors;
import cc.doctor.lovely.blog.dao.mapper.BlogCategoryMapper;
import cc.doctor.lovely.blog.dao.mapper.BlogPostMapper;
import cc.doctor.lovely.blog.dao.mapper.BlogTagMapper;
import cc.doctor.lovely.blog.dao.model.BlogPost;
import cc.doctor.lovely.blog.dao.model.BlogPostWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogService {
    @Autowired
    private BlogPostMapper blogPostMapper;
    @Autowired
    private BlogCategoryMapper blogCategoryMapper;
    @Autowired
    private BlogTagMapper blogTagMapper;

    @Transactional
    public CommonResponse post(PostBlogRequest postBlogRequest) {
        BlogPostWithBLOBs blogPostWithBLOBs = postBlogRequest.toBlogWithBlobs();
        if (postBlogRequest.getId() != null) {
            BlogPost blogPost = blogPostMapper.selectById(postBlogRequest.getId());
            Integer userId = blogPost.getUserId();
            if (!userId.equals(postBlogRequest.getUserId())) {
                return CommonResponse.errorResponse(Errors.ACCESS_DENY);
            }
            blogCategoryMapper.deleteByBlogId(postBlogRequest.getId());
            blogTagMapper.deleteByBlogId(postBlogRequest.getId());
            blogPostMapper.updateByPrimaryKeyWithBLOBs(blogPostWithBLOBs);

        } else {
            blogPostMapper.insertSelective(blogPostWithBLOBs);
        }
        return CommonResponse.successResponse(null);
    }

    public CommonResponse delete(DeleteBlogRequest deleteBlogRequest) {
        return null;
    }
}
