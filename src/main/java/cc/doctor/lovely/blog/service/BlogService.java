package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.controller.request.BlogListRequest;
import cc.doctor.lovely.blog.controller.request.DeleteBlogRequest;
import cc.doctor.lovely.blog.controller.request.PostBlogRequest;
import cc.doctor.lovely.blog.controller.response.BlogDetailResponse;
import cc.doctor.lovely.blog.controller.response.BlogListResponse;
import cc.doctor.lovely.blog.controller.response.CommentDetailResponse;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.dao.mapper.BlogPostMapper;
import cc.doctor.lovely.blog.dao.mapper.BlogPostTagMapper;
import cc.doctor.lovely.blog.dao.model.BlogPost;
import cc.doctor.lovely.blog.dao.model.BlogPostTag;
import cc.doctor.lovely.blog.dao.model.BlogPostWithBLOBs;
import cc.doctor.lovely.blog.dao.model.BlogPostWithSummary;
import com.google.common.base.Preconditions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {
    @Autowired
    private BlogPostMapper blogPostMapper;
    @Autowired
    private BlogPostTagMapper postTagMapper;
    @Autowired
    private CommentService commentService;

    @Transactional
    public CommonResponse post(PostBlogRequest postBlogRequest) {
        Preconditions.checkNotNull(postBlogRequest.getTitle());
        Preconditions.checkNotNull(postBlogRequest.getContent());

        BlogPostWithBLOBs blogPostWithBLOBs = postBlogRequest.toBlogWithBlobs();
        generateSummary(blogPostWithBLOBs);
        if (postBlogRequest.getId() != null) {
            BlogPost blogPost = blogPostMapper.selectById(postBlogRequest.getId());
            Integer userId = blogPost.getUserId();
            if (!userId.equals(postBlogRequest.getUserId())) {
                return CommonResponse.errorResponse(Errors.ACCESS_DENY);
            }
            blogPostMapper.updateByPrimaryKeyWithBLOBs(blogPostWithBLOBs);
        } else {
            blogPostMapper.insertSelective(blogPostWithBLOBs);
        }
        if (postBlogRequest.getTags() != null && !postBlogRequest.getTags().isEmpty()) {
            List<String> tagList = Arrays.asList(postBlogRequest.getTags().split(","));
            postTagMapper.insertPostTags(blogPostWithBLOBs.getId(), tagList);
        }
        return CommonResponse.successResponse(null);
    }

    private void generateSummary(BlogPostWithBLOBs blogPostWithBLOBs) {
        String summary = blogPostWithBLOBs.getSummary();
        if (summary == null || summary.isEmpty()) {
            String content = blogPostWithBLOBs.getContent();
            blogPostWithBLOBs.setSummary(content.length() > 256 ? content.substring(0, 255) : content);
        } else {
            if (summary.length() > 256) {
                blogPostWithBLOBs.setSummary(summary.substring(0, 255));
            }
        }
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
        // tags
        List<BlogPostTag> postTags = postTagMapper.selectByBlogId(id);
        blogDetailResponse.setTags(postTags.stream().map(input -> input.getTag()).collect(Collectors.toList()));
        // comments
        List<CommentDetailResponse> commentDetailResponses = commentService.getCommentDetails(Constants.SOURCE_ID, id);
        blogDetailResponse.setCommentDetails(commentDetailResponses);
        return blogDetailResponse;
    }

    public List<BlogListResponse> getBlogList(BlogListRequest blogListRequest) {
        List<BlogPostWithSummary> blogPosts = blogPostMapper.selectPage(blogListRequest.getBloggerId(), blogListRequest.getOrderBy(), blogListRequest.toRowBounds());
        return blogPosts.stream().map(input -> new BlogListResponse(input)).collect(Collectors.toList());
    }
}
