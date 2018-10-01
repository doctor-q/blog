package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.controller.request.AttentionRequest;
import cc.doctor.lovely.blog.controller.request.UnAttentionRequest;
import cc.doctor.lovely.blog.controller.request.UserRequest;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.dao.mapper.AttentionMapper;
import cc.doctor.lovely.blog.dao.model.Attention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttentionService {
    @Autowired
    private AttentionMapper attentionMapper;

    public CommonResponse attention(AttentionRequest attentionRequest) {
        Attention attention = attentionRequest.toAttention();
        attentionMapper.insertSelective(attention);
        return CommonResponse.successResponse(null);
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
