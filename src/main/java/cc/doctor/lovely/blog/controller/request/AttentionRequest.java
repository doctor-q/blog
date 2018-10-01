package cc.doctor.lovely.blog.controller.request;

import cc.doctor.lovely.blog.dao.model.Attention;
import lombok.Data;

@Data
public class AttentionRequest extends UserRequest {
    private Integer bloggerId;
    private String blogger;

    public Attention toAttention() {
        Attention attention = new Attention();
        attention.setFollowerId(getUserId());
        attention.setFollower(getUsername());
        attention.setBloggerId(bloggerId);
        attention.setBlogger(blogger);
        return attention;
    }
}
