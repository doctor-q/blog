package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.controller.request.BlogListRequest;
import cc.doctor.lovely.blog.controller.request.DeleteBlogRequest;
import cc.doctor.lovely.blog.controller.request.PostBlogRequest;
import cc.doctor.lovely.blog.controller.response.*;
import cc.doctor.lovely.blog.dao.mapper.BlogCategoryMapper;
import cc.doctor.lovely.blog.dao.mapper.BlogPostMapper;
import cc.doctor.lovely.blog.dao.mapper.BlogTagMapper;
import cc.doctor.lovely.blog.dao.model.BlogPost;
import cc.doctor.lovely.blog.dao.model.BlogPostWithBLOBs;
import cc.doctor.lovely.blog.dao.model.BlogPostWithSummary;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {
    @Autowired
    private BlogPostMapper blogPostMapper;
    @Autowired
    private BlogCategoryMapper blogCategoryMapper;
    @Autowired
    private BlogTagMapper blogTagMapper;
    @Autowired
    private CommentService commentService;

    @Transactional
    public CommonResponse post(PostBlogRequest postBlogRequest) {
        BlogPostWithBLOBs blogPostWithBLOBs = postBlogRequest.toBlogWithBlobs();
        if (postBlogRequest.getId() != null) {
            BlogPost blogPost = blogPostMapper.selectById(postBlogRequest.getId());
            Integer userId = blogPost.getUserId();
            if (!userId.equals(postBlogRequest.getUserId())) {
                return CommonResponse.errorResponse(Errors.ACCESS_DENY);
            }
            blogTagMapper.deleteByBlogId(postBlogRequest.getId());
            blogPostMapper.updateByPrimaryKeyWithBLOBs(blogPostWithBLOBs);
            blogTagMapper.insertTags(postBlogRequest.getId(), postBlogRequest.getTags());
        } else {
            blogPostMapper.insertSelective(blogPostWithBLOBs);
            blogTagMapper.insertTags(blogPostWithBLOBs.getId(), postBlogRequest.getTags());
        }
        return CommonResponse.successResponse(null);
    }

    public CommonResponse delete(DeleteBlogRequest deleteBlogRequest) {
        BlogPost blogPost = blogPostMapper.selectById(deleteBlogRequest.getId());
        Integer userId = blogPost.getUserId();
        if (!userId.equals(deleteBlogRequest.getUserId())) {
            return CommonResponse.errorResponse(Errors.ACCESS_DENY);
        }
        blogPostMapper.deleteByPrimaryKey(deleteBlogRequest.getId());
        return CommonResponse.successResponse(null);
    }

    public BlogDetailResponse getBlogDetail(Integer id) {
        BlogDetailResponse blogDetailResponse = new BlogDetailResponse();
        BlogPostWithBLOBs blogPostWithBLOBs = blogPostMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(blogPostWithBLOBs, blogDetailResponse);
        List<CommentDetailResponse> commentDetailResponses = commentService.getCommentDetails(Constants.SOURCE_ID, id);
        blogDetailResponse.setCommentDetails(commentDetailResponses);
        return blogDetailResponse;
    }

    public List<BlogListResponse> getBlogList(BlogListRequest blogListRequest) {
        List<BlogPostWithSummary> blogPosts = blogPostMapper.selectPage(blogListRequest.toRowBounds());
        return blogPosts.stream().map(input -> new BlogListResponse(input)).collect(Collectors.toList());
    }
}
