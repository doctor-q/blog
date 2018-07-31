package cc.doctor.lovely.blog.service;

import lombok.Getter;

public enum BlogStatus {
    DRAFT(0, "草稿"), UN_AUDIT(1, "待审核"), REJECT(2, "已拒绝"), PUBLISHED(3, "已发布");

    @Getter
    private int code;
    @Getter
    private String name;

    BlogStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static BlogStatus get(int code) {
        for (BlogStatus blogStatus : values()) {
            if (blogStatus.code == code) {
                return blogStatus;
            }
        }
        return null;
    }
}
