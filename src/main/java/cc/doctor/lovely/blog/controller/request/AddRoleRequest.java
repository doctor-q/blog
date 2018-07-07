package cc.doctor.lovely.blog.controller.request;

import cc.doctor.lovely.blog.dao.model.Role;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class AddRoleRequest extends AccessRequiredRequest {

    private static final long serialVersionUID = 6732666501958372277L;

    private String name;
    private List<Integer> resourceIds;
    private String description;

    public Role toRole() {
        Role role = new Role();
        BeanUtils.copyProperties(this, role);
        return role;
    }
}
