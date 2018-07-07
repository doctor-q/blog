package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.controller.request.AddResourceRequest;
import cc.doctor.lovely.blog.controller.request.DeleteResourceRequest;
import cc.doctor.lovely.blog.controller.request.PageRequest;
import cc.doctor.lovely.blog.controller.request.UpdateResourceRequest;
import cc.doctor.lovely.blog.controller.response.PageResponse;
import cc.doctor.lovely.blog.dao.mapper.ResourceMapper;
import cc.doctor.lovely.blog.dao.model.Resource;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lzx on 2018/1/9.
 * 权限服务
 */

@Transactional
@Service
public class ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    public PageResponse getResource(PageRequest pageRequest) {
        // 获取目前所有的权限
        int total = resourceMapper.selectCount();
        // 获取角色列表以及每个角色具有的权限
        List<Resource> list = resourceMapper.selectResourcePageable(pageRequest.getOffset(), pageRequest.getLimit());
        // 生成当前页面的信息
        PageResponse.Page page = new PageResponse.Page(pageRequest.getPage(), total);

        return new PageResponse<>(page, list);
    }

    public void newResource(AddResourceRequest addResourceRequest) {
        Preconditions.checkNotNull(addResourceRequest);
        Preconditions.checkNotNull(addResourceRequest.getName());

        resourceMapper.insertSelective(addResourceRequest.toResource());
    }

    public void updateResource(UpdateResourceRequest updateResourceRequest) {
        Preconditions.checkNotNull(updateResourceRequest);
        Preconditions.checkNotNull(updateResourceRequest.getId());

        resourceMapper.updateByPrimaryKey(updateResourceRequest.toResource());
    }

    public void deleteResource(DeleteResourceRequest deleteResourceRequest) {
        Preconditions.checkNotNull(deleteResourceRequest);
        Preconditions.checkNotNull(deleteResourceRequest.getId());

        resourceMapper.deleteByPrimaryKey(deleteResourceRequest.getId());
    }

}
