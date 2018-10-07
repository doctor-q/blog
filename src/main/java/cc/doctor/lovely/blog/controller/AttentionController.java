package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.request.AttentionRequest;
import cc.doctor.lovely.blog.controller.request.UnAttentionRequest;
import cc.doctor.lovely.blog.controller.request.UserRequest;
import cc.doctor.lovely.blog.service.AttentionService;
import cc.doctor.lovely.blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AttentionController {
    @Autowired
    private AttentionService attentionService;
    @Autowired
    private AuthService authService;

    @RequestMapping("attention")
    @ResponseBody
    public Object attention(AttentionRequest attentionRequest) {
        authService.setUserRequest(attentionRequest);
        return attentionService.attention(attentionRequest);
    }


    @RequestMapping("unAttention")
    @ResponseBody
    public Object unAttention(UnAttentionRequest unAttentionRequest) {
        authService.setUserRequest(unAttentionRequest);
        return attentionService.unAttention(unAttentionRequest);
    }

    @RequestMapping("getFollowers")
    @ResponseBody
    public Object getFollowers(UserRequest userRequest) {
        authService.setUserRequest(userRequest);
        return attentionService.getFollowers(userRequest);
    }

    @RequestMapping("getAttentions")
    @ResponseBody
    public Object getAttentions(UserRequest userRequest) {
        authService.setUserRequest(userRequest);
        return attentionService.getAttentions(userRequest);
    }
}
