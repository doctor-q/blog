package cc.doctor.lovely.blog.controller.request;

import cc.doctor.lovely.blog.dao.model.Blogger;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class UpdateContactRequest extends UserRequest {
    private Integer id;

    private String mobile;

    private String email;

    private String qq;

    private String github;

    private String weibo;

    private String facebook;

    private String twitter;

    public Blogger toBlogger() {
        Blogger blogger = new Blogger();
        BeanUtils.copyProperties(this, blogger);
        return blogger;
    }
}
