package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class DeleteRoleRequest extends AccessRequiredRequest {

    private static final long serialVersionUID = 7042113263415972927L;

    private Integer id;
}
