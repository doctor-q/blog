package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class AddCategoryRequest extends UserRequest {
    private String name;

    private Integer pid;
}
