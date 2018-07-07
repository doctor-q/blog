package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class DeleteResourceRequest extends AccessRequiredRequest {

    private static final long serialVersionUID = -599156545320997543L;

    private Integer id;
}
