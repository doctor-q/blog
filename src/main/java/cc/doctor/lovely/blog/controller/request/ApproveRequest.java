package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

@Data
public class ApproveRequest extends UserRequest {
    private Byte approval;

    private Integer sourceId;

    private Integer approvalRefId;
}
