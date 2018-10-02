package cc.doctor.lovely.blog.controller.request;

import cc.doctor.lovely.blog.dao.model.Blogger;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
public class RegisterRequest implements Serializable {
    private String email;
    private String username;
    private String password;

    public Blogger toBlogger() {
        Blogger blogger = new Blogger();
        BeanUtils.copyProperties(this, blogger);
        return blogger;
    }
}
