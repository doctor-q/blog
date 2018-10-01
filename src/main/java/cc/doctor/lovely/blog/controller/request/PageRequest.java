package cc.doctor.lovely.blog.controller.request;

import lombok.Data;
import org.apache.ibatis.session.RowBounds;


@Data
public class PageRequest {
    private static final long serialVersionUID = -7022848697987418010L;
    private Integer page = 1;
    private Integer pageNums = 10;

    public Integer getOffset() {
        return (page - 1) * pageNums;
    }

    public Integer getLimit() {
        return pageNums;
    }

    public RowBounds toRowBounds() {
        return new RowBounds(getOffset(), getLimit());
    }
}
