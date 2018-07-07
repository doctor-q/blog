package cc.doctor.lovely.blog.controller.request;

import cc.doctor.lovely.blog.dao.model.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class UpdateUserRequest extends AccessRequiredRequest {
    private static final long serialVersionUID = 9038190153118230319L;

    private Integer id;
    private String username;
    private String email;
    private String password;
    private List<Integer> roleList;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(UpdateOwnerRequest updateOwnerRequest) {
        this.id = updateOwnerRequest.getId();
        this.username = updateOwnerRequest.getUsername();
        this.email = updateOwnerRequest.getEmail();
        this.password = updateOwnerRequest.getPassword();
    }

    public UpdateUserRequest(UpdateOwnerEmailRequest updateOwnerEmailRequest) {
        this.id = updateOwnerEmailRequest.getId();
        this.email = updateOwnerEmailRequest.getNewEmail();
    }

    public UpdateUserRequest(UpdateOwnerPasswordRequest updateOwnerPasswordRequest) {
        this.id = updateOwnerPasswordRequest.getId();
        this.password = updateOwnerPasswordRequest.getNewPassword();
    }

    public User toUser() {
        User user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }
}
