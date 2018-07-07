package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.controller.request.AddUserRequest;
import cc.doctor.lovely.blog.controller.request.DeleteUserRequest;
import cc.doctor.lovely.blog.controller.request.PageRequest;
import cc.doctor.lovely.blog.controller.request.UpdateUserRequest;
import cc.doctor.lovely.blog.controller.response.CommonResponse;
import cc.doctor.lovely.blog.controller.response.Errors;
import cc.doctor.lovely.blog.controller.response.PageResponse;
import cc.doctor.lovely.blog.controller.response.UserListResponse;
import cc.doctor.lovely.blog.dao.OffsetLimit;
import cc.doctor.lovely.blog.dao.mapper.CommonMapper;
import cc.doctor.lovely.blog.dao.mapper.UserMapper;
import cc.doctor.lovely.blog.dao.mapper.UserRoleMapper;
import cc.doctor.lovely.blog.dao.model.User;
import cc.doctor.lovely.blog.dao.model.UserRole;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private CommonMapper commonMapper;

    @Value("user.initial.password")
    private String userInitPassword;

    @Transactional
    public CommonResponse addUser(AddUserRequest addUserRequest) {
        Preconditions.checkNotNull(addUserRequest);
        Preconditions.checkNotNull(addUserRequest.getUsername(), Errors.PARAMETER_MISSING.getMessage());
        Preconditions.checkNotNull(addUserRequest.getEmail(), Errors.PARAMETER_MISSING.getMessage());

        addUserRequest.setPassword(userInitPassword);
        User user = addUserRequest.toUser();
        userMapper.insertSelective(user);
        if (addUserRequest.getRoleList() != null && !addUserRequest.getRoleList().isEmpty()) {
            userRoleMapper.insertUserRoles(user.getId(), addUserRequest.getRoleList());
        }
        return CommonResponse.successResponse(null);
    }

    public boolean usernameExist(String username) {
        Preconditions.checkNotNull(username);
        User user = userMapper.selectByName(username);
        return user != null;
    }

    public boolean emailExist(String email) {
        Preconditions.checkNotNull(email);

        User user = userMapper.selectByEmail(email);
        return user != null;
    }

    public User getUser(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        Preconditions.checkNotNull(username);
        Preconditions.checkNotNull(password);

        return userMapper.selectByNameAndPassword(username, password);
    }

    @Transactional
    public CommonResponse updateUser(UpdateUserRequest updateUserRequest) {
        Preconditions.checkNotNull(updateUserRequest);
        Preconditions.checkNotNull(updateUserRequest.getId());

        userMapper.updateByPrimaryKeySelective(updateUserRequest.toUser());
        if (updateUserRequest.getRoleList() != null && !updateUserRequest.getRoleList().isEmpty()) {
            userRoleMapper.deleteByUserId(updateUserRequest.getId());
            userRoleMapper.insertUserRoles(updateUserRequest.getId(), updateUserRequest.getRoleList());
        }
        return CommonResponse.successResponse(null);
    }

    public CommonResponse deleteUser(DeleteUserRequest deleteUserRequest) {
        Preconditions.checkNotNull(deleteUserRequest);
        Preconditions.checkNotNull(deleteUserRequest.getId());

        userMapper.deleteByPrimaryKey(deleteUserRequest.getId());
        return CommonResponse.successResponse(null);
    }

    public PageResponse<UserListResponse> getAllUsers(PageRequest pageRequest) {
        Preconditions.checkNotNull(pageRequest);

        int total = userMapper.selectCount();
        List<User> users = userMapper.selectPageable(new OffsetLimit(pageRequest));

        List<Integer> userIds = Lists.transform(users, new Function<User, Integer>() {
            @Override
            public Integer apply(User user) {
                return user.getId();
            }
        });
        final Map<Integer, List<UserListResponse.RoleInfo>> userRoles = new HashMap<>();
        if (!userIds.isEmpty()) {
            List<UserRole> roles = userRoleMapper.selectByUserIds(userIds);
            for (UserRole userRole : roles) {
                if (!userRoles.containsKey(userRole.getUserId())) {
                    userRoles.put(userRole.getUserId(), new LinkedList<UserListResponse.RoleInfo>());
                }
                userRoles.get(userRole.getUserId()).add(new UserListResponse.RoleInfo(userRole));
            }
        }

        PageResponse.Page page = new PageResponse.Page(pageRequest.getPage(), total);
        List<UserListResponse> userList = Lists.transform(users, new Function<User, UserListResponse>() {
            @Override
            public UserListResponse apply(User user) {
                UserListResponse userListResponse = new UserListResponse(user);
                userListResponse.setRoleList(userRoles.get(user.getId()));
                return userListResponse;
            }
        });
        return new PageResponse<>(page, userList);
    }
}
