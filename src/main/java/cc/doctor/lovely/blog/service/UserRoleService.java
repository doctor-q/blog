package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.dao.mapper.ResourceMapper;
import cc.doctor.lovely.blog.dao.mapper.RoleResourceMapper;
import cc.doctor.lovely.blog.dao.mapper.UserMapper;
import cc.doctor.lovely.blog.dao.mapper.UserRoleMapper;
import cc.doctor.lovely.blog.dao.model.Resource;
import cc.doctor.lovely.blog.dao.model.RoleResource;
import cc.doctor.lovely.blog.dao.model.UserRole;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleResourceMapper roleResourceMapper;
    @Autowired
    private ResourceMapper resourceMapper;

    public Boolean canAccessResource(Integer userId, String resourceName) {
        if (userId == null) {
            return false;
        }
        if (resourceName == null) {
            return true;
        }
        List<UserRole> userRoles = userRoleMapper.selectByUserId(userId);
        if (userRoles.isEmpty()) {
            return false;
        }
        List<Integer> roleIds = Lists.transform(userRoles, new Function<UserRole, Integer>() {
            @Override
            public Integer apply(UserRole userRole) {
                return userRole.getRoleId();
            }
        });
        List<RoleResource> roleResources = roleResourceMapper.selectByRoleIds(roleIds);
        Resource resource = resourceMapper.selectByName(resourceName);
        if (resource == null) {
            return false;
        }
        return Lists.transform(roleResources, new Function<RoleResource, Integer>() {
            @Override
            public Integer apply(RoleResource roleResource) {
                return roleResource.getResourceId();
            }
        }).contains(resource.getId());
    }
}
