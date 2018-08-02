package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.controller.request.AttentionRequest;
import cc.doctor.lovely.blog.controller.request.UnAttentionRequest;
import cc.doctor.lovely.blog.controller.request.UserRequest;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import org.springframework.stereotype.Service;

@Service
public class AttentionService {
    public CommonResponse attention(AttentionRequest attentionRequest) {
        return null;
    }

    public CommonResponse unAttention(UnAttentionRequest unAttentionRequest) {
        return null;
    }

    public CommonResponse getFollowers(UserRequest userRequest) {
        return null;
    }

    public CommonResponse getAttentions(UserRequest userRequest) {
        return null;
    }
}
