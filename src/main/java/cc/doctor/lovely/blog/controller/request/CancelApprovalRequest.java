package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class CancelApprovalRequest extends UserRequest {
    private Integer id;
}
