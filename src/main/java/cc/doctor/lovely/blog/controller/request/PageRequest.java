package cc.doctor.lovely.blog.controller.request;

import cc.doctor.lovely.blog.dao.OffsetLimit;
import lombok.Data;


@Data
public class PageRequest {
    private static final long serialVersionUID = -7022848697987418010L;
    public Integer page = 1;
    public Integer pageNums = 10;

    public Integer getOffset() {
        return (page - 1) * pageNums;
    }

    public Integer getLimit() {
        return pageNums;
    }

    public OffsetLimit toOffsetLimit() {
        OffsetLimit offsetLimit = new OffsetLimit();
        offsetLimit.setOffset(getOffset());
        offsetLimit.setLimit(getLimit());
        return offsetLimit;
    }
}
