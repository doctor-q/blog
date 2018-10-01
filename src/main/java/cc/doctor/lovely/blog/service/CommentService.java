package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.controller.request.CommentRequest;
import cc.doctor.lovely.blog.controller.request.DeleteCommentRequest;
import cc.doctor.lovely.blog.controller.response.CommentDetailResponse;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.dao.mapper.CommentMapper;
import cc.doctor.lovely.blog.dao.model.Comment;
import cc.doctor.lovely.blog.dao.model.SourceRefCount;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public CommonResponse comment(CommentRequest commentRequest) {
        Comment comment = commentRequest.toComment();
        commentMapper.insertSelective(comment);
        return CommonResponse.successResponse(null);
    }

    public CommonResponse deleteComment(DeleteCommentRequest deleteCommentRequest) {
        commentMapper.deleteByPrimaryKey(deleteCommentRequest.getId());
        return CommonResponse.successResponse();
    }

    public List<CommentDetailResponse> getCommentDetails(Integer sourceId, Integer commentRefId) {
        List<Comment> comments = commentMapper.selectRefComment(sourceId, commentRefId, new RowBounds());
        return comments.stream().map(input -> new CommentDetailResponse(input)).collect(Collectors.toList());
    }
}
