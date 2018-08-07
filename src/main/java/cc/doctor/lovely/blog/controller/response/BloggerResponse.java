package cc.doctor.lovely.blog.controller.response;

import cc.doctor.lovely.blog.dao.model.Blogger;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class BloggerResponse extends Blogger {

    public BloggerResponse() {
    }

    public BloggerResponse(Blogger blogger) {
        BeanUtils.copyProperties(blogger, this);
    }
}
