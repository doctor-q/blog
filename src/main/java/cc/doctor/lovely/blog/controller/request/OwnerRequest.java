package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class OwnerRequest extends AccessRequiredRequest {
    private static final long serialVersionUID = -4081559203729664825L;

    public Integer id;
}
