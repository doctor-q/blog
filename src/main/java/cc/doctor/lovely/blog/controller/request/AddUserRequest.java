package cc.doctor.lovely.blog.controller.request;

import cc.doctor.lovely.blog.dao.model.User;
import lombok.Data;

import java.util.List;

@Data
public class AddUserRequest extends AccessRequiredRequest {
    private static final long serialVersionUID = 2417452349825160897L;

    private String username;
    private String email;
    private String password;
    private List<Integer> roleList;

    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
