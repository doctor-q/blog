package cc.doctor.lovely.blog.controller.request;

import cc.doctor.lovely.blog.dao.model.Blogger;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class UpdateBloggerRequest extends UserRequest {
    private Integer id;

    private String header;

    private Byte gender;

    private Date birthday;

    private String address;

    private String company;

    private String position;

    private Byte marriageStatus;

    public Blogger toBlogger() {
        Blogger blogger = new Blogger();
        BeanUtils.copyProperties(this, blogger);
        return blogger;
    }
}
