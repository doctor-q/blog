package cc.doctor.lovely.blog.controller.response;

import cc.doctor.lovely.blog.dao.model.User;
import cc.doctor.lovely.blog.dao.model.UserRole;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserListResponse implements Serializable {
    private static final long serialVersionUID = 6727923041168151426L;

    private Integer id;
    private String username;
    private String email;
    private List<RoleInfo> roleList;

    public UserListResponse() {
    }

    public UserListResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

    @Data
    public static class RoleInfo implements Serializable {
        private static final long serialVersionUID = 5624247498800762815L;
        private Integer roleId;
        private String name;

        public RoleInfo(UserRole userRole) {
            this.roleId = userRole.getRoleId();
        }
    }
}
