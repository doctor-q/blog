package cc.doctor.lovely.blog.controller.request;

import cc.doctor.lovely.blog.dao.model.Resource;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class UpdateResourceRequest extends AccessRequiredRequest {

    private static final long serialVersionUID = 2485369977146494926L;
    private Integer id;
    private String name;
    private String menuLink;
    private String description;

    public Resource toResource() {
        Resource resource = new Resource();
        BeanUtils.copyProperties(this, resource);
        return resource;
    }
}
