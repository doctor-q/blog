package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class UpdateOwnerRequest extends OwnerRequest {
    private static final long serialVersionUID = 8808314903496193802L;

    private String username;
    private String email;
    private String password;
}
