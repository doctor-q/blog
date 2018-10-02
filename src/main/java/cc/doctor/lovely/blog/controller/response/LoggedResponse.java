package cc.doctor.lovely.blog.controller.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoggedResponse implements Serializable {
    private String id;
    private String username;
}
