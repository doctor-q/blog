package cc.doctor.lovely.blog.controller.request;

import cc.doctor.lovely.blog.dao.model.Role;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class UpdateRoleRequest extends AccessRequiredRequest {

    private static final long serialVersionUID = -7585555113444008865L;

    private Integer id;
    private String name;
    private String description;
    private List<Integer> resourceIds;

    public Role roRole() {
        Role role = new Role();
        BeanUtils.copyProperties(this, role);
        return role;
    }
}
