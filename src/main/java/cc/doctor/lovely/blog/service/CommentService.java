package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.controller.request.CommentRequest;
import cc.doctor.lovely.blog.controller.request.DeleteCommentRequest;
import cc.doctor.lovely.blog.controller.response.CommentDetailResponse;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.dao.model.SourceRefCount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    public CommonResponse comment(CommentRequest commentRequest) {
        return null;
    }

    public CommonResponse deleteComment(DeleteCommentRequest deleteCommentRequest) {
        return null;
    }

    public List<SourceRefCount> getCommentCounts(Integer sourceId, List<Integer> commentRefIds) {
        return null;
    }

    public List<CommentDetailResponse> getCommentDetails(Integer sourceId, Integer commentRefId) {
        return null;
    }
}
