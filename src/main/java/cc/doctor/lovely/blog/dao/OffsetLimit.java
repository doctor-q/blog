package cc.doctor.lovely.blog.dao;

import cc.doctor.lovely.blog.controller.request.PageRequest;
import lombok.Data;

@Data
public class OffsetLimit {
    private int offset;
    private int limit;

    public OffsetLimit() {
    }

    public OffsetLimit(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public OffsetLimit(PageRequest pageRequest) {
        this.offset = pageRequest.getOffset();
        this.limit = pageRequest.getLimit();
    }

}
