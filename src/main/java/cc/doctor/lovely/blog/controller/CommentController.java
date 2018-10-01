package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.request.CommentRequest;
import cc.doctor.lovely.blog.controller.request.DeleteCommentRequest;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.service.AuthService;
import cc.doctor.lovely.blog.service.CommentService;
import cc.doctor.lovely.blog.service.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private AuthService authService;

    @RequestMapping("add")
    @ResponseBody
    public CommonResponse comment(CommentRequest commentRequest) {
        authService.setUserRequest(commentRequest);
        commentRequest.setSourceId(Constants.SOURCE_ID);
        return commentService.comment(commentRequest);
    }

    @RequestMapping("delete")
    @ResponseBody
    public CommonResponse deleteComment(DeleteCommentRequest deleteCommentRequest) {
        authService.setUserRequest(deleteCommentRequest);
        return commentService.deleteComment(deleteCommentRequest);
    }
}
