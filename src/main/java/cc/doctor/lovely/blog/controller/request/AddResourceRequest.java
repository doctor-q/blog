package cc.doctor.lovely.blog.controller.request;

import cc.doctor.lovely.blog.dao.model.Resource;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class AddResourceRequest extends AccessRequiredRequest {

    private static final long serialVersionUID = -6378555375750811457L;

    private String name;
    private String menuLink;
    private String description;

    public Resource toResource() {
        Resource resource = new Resource();
        BeanUtils.copyProperties(this, resource);
        return resource;
    }
}
