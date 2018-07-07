package cc.doctor.lovely.blog.controller.response;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageResponse<T> extends CommonResponse<Map<String, Object>> {
    private static final long serialVersionUID = -7861817969564718757L;

    public PageResponse(Page page, List<T> tList) {
        Map<String, Object> data = new HashMap<>();
        data.put("pageInfo", page);
        data.put("list", tList);
        setData(data);
    }

    @Data
    public static class Page implements Serializable {
        private static final long serialVersionUID = 2639403568483998785L;
        private Integer page;
        private Integer total;

        public Page(Integer page, int total) {
            this.page = page;
            this.total = total;
        }
    }
}
