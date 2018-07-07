package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.controller.request.AddRoleRequest;
import cc.doctor.lovely.blog.controller.request.DeleteRoleRequest;
import cc.doctor.lovely.blog.controller.request.PageRequest;
import cc.doctor.lovely.blog.controller.request.UpdateRoleRequest;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.controller.response.PageResponse;
import cc.doctor.lovely.blog.controller.response.RoleListResponse;
import cc.doctor.lovely.blog.dao.mapper.ResourceMapper;
import cc.doctor.lovely.blog.dao.mapper.RoleMapper;
import cc.doctor.lovely.blog.dao.mapper.RoleResourceMapper;
import cc.doctor.lovely.blog.dao.model.Resource;
import cc.doctor.lovely.blog.dao.model.Role;
import cc.doctor.lovely.blog.dao.model.RoleResource;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class RoleResourceService {

    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private RoleResourceMapper roleResourceMapper;
    @Autowired
    private RoleMapper roleMapper;

    public PageResponse getRole(PageRequest pageRequest) {
        // 获取目前所有的角色
        int total = roleMapper.selectAllRole();
        // 获取角色列表以及每个角色具有的权限
        List<Role> roles = roleMapper.selectPageable(pageRequest.toOffsetLimit());
        // 根据权限列表查询相应权限
        List<Integer> roleIds = Lists.transform(roles, new Function<Role, Integer>() {
            @Override
            public Integer apply(Role input) {
                return input.getId();
            }
        });
        List<RoleResource> roleResources = roleResourceMapper.selectByRoleIds(roleIds);
        Map<Integer, List<RoleResource>> roleResourceMap = new HashMap<>();
        List<Integer> resourceIds = new LinkedList<>();
        for (RoleResource roleResource : roleResources) {
            resourceIds.add(roleResource.getResourceId());
            List<RoleResource> resources = roleResourceMap.computeIfAbsent(roleResource.getId(), new Function<Integer, List<RoleResource>>() {
                @Override
                public List<RoleResource> apply(Integer input) {
                    return new LinkedList<>();
                }
            });
            resources.add(roleResource);
        }
        // 获取所有resource
        Map<Integer, Resource> resourceMap = new HashMap<>();
        List<Resource> resources = resourceMapper.selectByIds(resourceIds);
        for (Resource resource : resources) {
            resourceMap.put(resource.getId(), resource);
        }
        List<RoleListResponse> roleListResponses = new LinkedList<>();
        for (Role role : roles) {
            RoleListResponse roleListResponse = new RoleListResponse(role);
            List<RoleResource> roleResourceList = roleResourceMap.get(role.getId());
            List<Resource> resourceList = new LinkedList<>();
            if (roleResourceList != null) {
                for (RoleResource roleResource : roleResourceList) {
                    resourceList.add(resourceMap.get(roleResource.getResourceId()));
                }
            }
            roleListResponse.setResourceList(resourceList);
        }
        // 生成当前页面的信息
        PageResponse.Page page = new PageResponse.Page(pageRequest.getPage(), total);

        return new PageResponse<>(page, roleListResponses);
    }

    public RoleListResponse getRole(Integer roleId) {
        Preconditions.checkNotNull(roleId);
        return new RoleListResponse(roleMapper.selectByPrimaryKey(roleId));
    }

    public CommonResponse newRole(AddRoleRequest addRoleRequest) {
        Preconditions.checkNotNull(addRoleRequest);
        Preconditions.checkNotNull(addRoleRequest.getName());
        Preconditions.checkNotNull(addRoleRequest.getResourceIds());

        // 判断角色不存在数据库
        if (null != roleMapper.selectByName(addRoleRequest.getName())) {
            return CommonResponse.failedResponse();
        }

        // 将角色添加到角色表
        Role role = addRoleRequest.toRole();
        roleMapper.insertSelective(role);

        // 将需要赋予角色的权限分别添加到角色权限关系表中
        roleResourceMapper.insertRoleResources(role.getId(), addRoleRequest.getResourceIds());

        return CommonResponse.successResponse("添加角色成功");
    }

    public CommonResponse updateRole(UpdateRoleRequest updateRoleRequest) {
        Preconditions.checkNotNull(updateRoleRequest);
        Preconditions.checkNotNull(updateRoleRequest.getId());

        if (updateRoleRequest.getResourceIds() != null) {
            // 角色具有的规则列表改变后,删除之前添加的权限列表
            roleResourceMapper.deleteByRoleId(updateRoleRequest.getId());
            roleResourceMapper.insertRoleResources(updateRoleRequest.getId(), updateRoleRequest.getResourceIds());
        }

        // 修改角色基本信息
        roleMapper.updateByPrimaryKeySelective(updateRoleRequest.roRole());
        return CommonResponse.successResponse("修改角色成功");

    }

    public CommonResponse deleteRole(DeleteRoleRequest deleteRoleRequest) {
        Preconditions.checkNotNull(deleteRoleRequest);
        Preconditions.checkNotNull(deleteRoleRequest.getId());

        roleMapper.deleteByPrimaryKey(deleteRoleRequest.getId());
        roleResourceMapper.deleteByPrimaryKey(deleteRoleRequest.getId());
        return CommonResponse.successResponse("修改角色成功");
    }

    public boolean roleExist(String name) {
        Preconditions.checkNotNull(name);
        Role role = roleMapper.selectByName(name);
        return role != null;
    }
}
