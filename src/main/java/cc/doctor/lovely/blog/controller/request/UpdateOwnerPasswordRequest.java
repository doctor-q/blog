package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class UpdateOwnerPasswordRequest extends OwnerRequest {
    private static final long serialVersionUID = -2457558942842958363L;

    private String oldPassword;
    private String newPassword;
}
