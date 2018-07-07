package cc.doctor.lovely.blog.controller;

/**
 * Created by lzx on 2018/1/9.
 * 权限控制器
 */

import cc.doctor.lovely.blog.controller.request.AddResourceRequest;
import cc.doctor.lovely.blog.controller.request.DeleteResourceRequest;
import cc.doctor.lovely.blog.controller.request.PageRequest;
import cc.doctor.lovely.blog.controller.request.UpdateResourceRequest;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @RequestMapping("/getResource")
    public CommonResponse getResource(PageRequest resource) {

        try {
            return CommonResponse.successResponse(resourceService.getResource(resource));
        } catch (Exception e) {
            logger.error("获取权限失败", e);
            return CommonResponse.failedResponse();
        }
    }

    @RequestMapping("/newResource")
    public CommonResponse newResource(AddResourceRequest resource) {

        try {
            resourceService.newResource(resource);
        } catch (Exception e) {
            logger.error("新建权限失败", e);
            return CommonResponse.failedResponse();
        }
        return CommonResponse.successResponse("新建权限成功");
    }

    @RequestMapping("/updateResource")
    public CommonResponse updateResource(UpdateResourceRequest resource) {

        try {
            resourceService.updateResource(resource);
        } catch (Exception e) {
            logger.error("修改权限失败", e);
            return CommonResponse.failedResponse();
        }
        return CommonResponse.successResponse("修改权限成功");
    }

    @RequestMapping("/deleteResource")
    public CommonResponse deleteResource(DeleteResourceRequest resource) {

        try {
            resourceService.deleteResource(resource);
        } catch (Exception e) {
            logger.error("删除权限失败", e);
            return CommonResponse.failedResponse();
        }
        return CommonResponse.successResponse("删除权限成功");
    }

}
