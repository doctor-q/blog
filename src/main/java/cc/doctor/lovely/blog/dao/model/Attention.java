package cc.doctor.lovely.blog.dao.model;

import java.util.Date;

public class Attention {
    private Integer id;

    private Integer bloggerId;

    private String blogger;

    private Integer followerId;

    private String follower;

    private Byte isDeleted;

    private Date createdAt;

    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBloggerId() {
        return bloggerId;
    }

    public void setBloggerId(Integer bloggerId) {
        this.bloggerId = bloggerId;
    }

    public String getBlogger() {
        return blogger;
    }

    public void setBlogger(String blogger) {
        this.blogger = blogger == null ? null : blogger.trim();
    }

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower == null ? null : follower.trim();
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}