package cc.doctor.lovely.blog.controller.response;

import cc.doctor.lovely.blog.dao.model.Resource;
import cc.doctor.lovely.blog.dao.model.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lzx on 2018/1/10.
 * 权限列表
 */
@Data
public class RoleListResponse implements Serializable {

    private static final long serialVersionUID = 7523688459964181904L;
    private Integer id;
    private String name;
    private String description;
    private List<Resource> resourceList;
    private String resourceListStr;

    public RoleListResponse(Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.description = role.getDescription();
    }
}
