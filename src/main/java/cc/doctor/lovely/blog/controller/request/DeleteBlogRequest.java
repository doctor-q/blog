package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class DeleteBlogRequest extends UserRequest {
    private Integer id;
}
