package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class UpdateOwnerEmailRequest extends OwnerRequest {
    private static final long serialVersionUID = 5421458585102252264L;

    private String oldEmail;
    private String newEmail;
}
