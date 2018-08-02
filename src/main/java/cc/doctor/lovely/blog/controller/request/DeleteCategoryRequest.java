package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class DeleteCategoryRequest extends UserRequest {
    private Integer id;
    // 强制删除会删除子分类
    private boolean force;
}
