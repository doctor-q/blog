package cc.doctor.lovely.blog.controller;

/**
 * Created by lzx on 2018/1/9.
 * 权限控制器
 */

import cc.doctor.lovely.blog.controller.request.AddRoleRequest;
import cc.doctor.lovely.blog.controller.request.DeleteRoleRequest;
import cc.doctor.lovely.blog.controller.request.PageRequest;
import cc.doctor.lovely.blog.controller.request.UpdateRoleRequest;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.controller.response.Errors;
import cc.doctor.lovely.blog.controller.response.PageResponse;
import cc.doctor.lovely.blog.controller.response.RoleListResponse;
import cc.doctor.lovely.blog.service.RoleResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleResourceService roleResourceService;

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @RequestMapping("/getRole")
    public CommonResponse<PageResponse> getRole(PageRequest resource) {

        try {
            return CommonResponse.successResponse(roleResourceService.getRole(resource));
        } catch (Exception e) {
            logger.error("获取权限失败", e);
            return CommonResponse.failedResponse();
        }
    }

    @RequestMapping("/newRole")
    public CommonResponse newRole(AddRoleRequest addRoleRequest) {
        if (roleResourceService.roleExist(addRoleRequest.getName())) {
            return CommonResponse.errorResponse(Errors.ROLE_EXISTS);
        }
        try {
            return roleResourceService.newRole(addRoleRequest);
        } catch (Exception e) {
            logger.error("获取权限失败", e);
            return CommonResponse.failedResponse();
        }
    }

    @RequestMapping("/updateRole")
    public CommonResponse updateRole(UpdateRoleRequest updateRoleRequest) {
        RoleListResponse role = roleResourceService.getRole(updateRoleRequest.getId());
        if (!role.getName().equals(updateRoleRequest.getName()) && roleResourceService.roleExist(updateRoleRequest.getName())) {
            return CommonResponse.errorResponse(Errors.ROLE_EXISTS);
        }
        try {
            return roleResourceService.updateRole(updateRoleRequest);
        } catch (Exception e) {
            logger.error("修改权限失败", e);
            return CommonResponse.failedResponse();
        }
    }

    @RequestMapping("/deleteRole")
    public CommonResponse delteRole(DeleteRoleRequest resource) {

        try {
            return roleResourceService.deleteRole(resource);
        } catch (Exception e) {
            logger.error("删除权限失败", e);
            return CommonResponse.failedResponse();
        }
    }
}
