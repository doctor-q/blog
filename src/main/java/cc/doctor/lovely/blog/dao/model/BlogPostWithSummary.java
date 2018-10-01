package cc.doctor.lovely.blog.dao.model;

public class BlogPostWithSummary extends BlogPost {
    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
