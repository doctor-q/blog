package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.request.CommentRequest;
import cc.doctor.lovely.blog.controller.request.DeleteCommentRequest;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    public CommonResponse comment(CommentRequest commentRequest) {
        return null;
    }

    public CommonResponse deleteComment(DeleteCommentRequest deleteCommentRequest) {
        return null;
    }
}
