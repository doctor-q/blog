package cc.doctor.lovely.blog.controller.response;

import cc.doctor.lovely.blog.dao.model.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetOwnerResponse implements Serializable {
    private static final long serialVersionUID = -5794388327132804830L;
    private String username;
    private String email;

    public GetOwnerResponse(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
