package cc.doctor.lovely.blog.controller;

import cc.doctor.lovely.blog.controller.request.ApproveRequest;
import cc.doctor.lovely.blog.controller.request.CancelApprovalRequest;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.service.ApprovalService;
import cc.doctor.lovely.blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("approval")
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;

    @Autowired
    private AuthService authService;

    @RequestMapping("approve")
    public CommonResponse approve(ApproveRequest approveRequest) {
        authService.setUserRequest(approveRequest);
        return approvalService.approve(approveRequest);
    }

    @RequestMapping("cancel")
    public CommonResponse cancel(CancelApprovalRequest cancelApprovalRequest) {
        authService.setUserRequest(cancelApprovalRequest);
        return approvalService.cancel(cancelApprovalRequest);
    }
}
