package cc.doctor.lovely.blog.dao.model;

import java.util.Date;

public class Approval {
    private Integer id;

    private Byte approval;

    private Integer sourceId;

    private Integer approvalRefId;

    private Integer userId;

    private Date createdAt;

    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getApproval() {
        return approval;
    }

    public void setApproval(Byte approval) {
        this.approval = approval;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getApprovalRefId() {
        return approvalRefId;
    }

    public void setApprovalRefId(Integer approvalRefId) {
        this.approvalRefId = approvalRefId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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