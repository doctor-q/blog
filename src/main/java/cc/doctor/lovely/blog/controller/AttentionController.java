package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.request.AttentionRequest;
import cc.doctor.lovely.blog.controller.request.UnAttentionRequest;
import cc.doctor.lovely.blog.controller.request.UserRequest;
import cc.doctor.lovely.blog.service.AttentionService;
import cc.doctor.lovely.blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AttentionController {
    @Autowired
    private AttentionService attentionService;
    @Autowired
    private AuthService authService;

    @RequestMapping("attention")
    public Object attention(AttentionRequest attentionRequest) {
        authService.setUserRequest(attentionRequest);
        return attentionService.attention(attentionRequest);
    }


    @RequestMapping("unAttention")
    public Object unAttention(UnAttentionRequest unAttentionRequest) {
        authService.setUserRequest(unAttentionRequest);
        return attentionService.unAttention(unAttentionRequest);
    }

    @RequestMapping("getFollowers")
    public Object getFollowers(UserRequest userRequest) {
        authService.setUserRequest(userRequest);
        return attentionService.getFollowers(userRequest);
    }

    @RequestMapping("getAttentions")
    public Object getAttentions(UserRequest userRequest) {
        authService.setUserRequest(userRequest);
        return attentionService.getAttentions(userRequest);
    }
}
