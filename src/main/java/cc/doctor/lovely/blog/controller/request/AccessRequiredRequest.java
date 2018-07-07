package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccessRequiredRequest implements Serializable {
    private static final long serialVersionUID = -8021978786306844117L;

    public String accessToken;
}
