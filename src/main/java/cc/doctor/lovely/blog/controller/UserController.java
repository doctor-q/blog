package cc.doctor.lovely.blog.controller;


import cc.doctor.lovely.blog.controller.request.*;
import cc.doctor.lovely.blog.controller.response.*;
import cc.doctor.lovely.blog.dao.model.User;
import cc.doctor.lovely.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/newUser")
    public CommonResponse addUser(AddUserRequest addUserRequest) {
        if (userService.usernameExist(addUserRequest.getUsername())) {
            return CommonResponse.errorResponse(Errors.USERNAME_EXISTS);
        }
        if (userService.emailExist(addUserRequest.getEmail())) {
            return CommonResponse.errorResponse(Errors.EMAIL_EXISTS);
        }
        return userService.addUser(addUserRequest);
    }

    private CommonResponse updateUserCheck(Integer userId, String newUsername, String newEmail) {
        User oldUser = userService.getUser(userId);
        if (!oldUser.getUsername().equals(newUsername) && userService.usernameExist(newUsername)) {
            return CommonResponse.errorResponse(Errors.USERNAME_EXISTS);
        }
        if (!oldUser.getEmail().equals(newEmail) && userService.emailExist(newEmail)) {
            return CommonResponse.errorResponse(Errors.EMAIL_EXISTS);
        }
        return null;
    }

    @RequestMapping("/updateUser")
    public CommonResponse updateUser(UpdateUserRequest updateUserRequest) {
        CommonResponse commonResponse = updateUserCheck(updateUserRequest.getId(), updateUserRequest.getUsername(), updateUserRequest.getEmail());
        if (commonResponse != null) {
            return commonResponse;
        }
        return userService.updateUser(updateUserRequest);
    }

    @RequestMapping("/deleteUser")
    public CommonResponse deleteUser(DeleteUserRequest deleteUserRequest) {
        return userService.deleteUser(deleteUserRequest);
    }

    @RequestMapping("/getUser")
    public PageResponse<UserListResponse> getUsers(PageRequest pageRequest) {
        return userService.getAllUsers(pageRequest);
    }

    @RequestMapping("/getOwner")
    public CommonResponse getOwner(OwnerRequest ownerRequest) {
        User user = userService.getUser(ownerRequest.getId());
        if (user == null) {
            return CommonResponse.errorResponse(Errors.USER_NOT_EXIST);
        }
        return CommonResponse.successResponse(new GetOwnerResponse(user));
    }

    @RequestMapping("/updateOwner")
    public CommonResponse updateOwner(UpdateOwnerRequest updateOwnerRequest) {
        CommonResponse commonResponse = updateUserCheck(updateOwnerRequest.getId(), updateOwnerRequest.getUsername(), updateOwnerRequest.getEmail());
        if (commonResponse != null) {
            return commonResponse;
        }
        return userService.updateUser(new UpdateUserRequest(updateOwnerRequest));
    }

    @RequestMapping("/updateOwnerEmail")
    public CommonResponse updateOwnerEmail(UpdateOwnerEmailRequest updateOwnerEmailRequest) {
        User user = userService.getUser(updateOwnerEmailRequest.getId());
        if (!user.getEmail().equals(updateOwnerEmailRequest.getOldEmail())) {
            return CommonResponse.errorResponse(Errors.OLD_EMAIL_WRONG);
        }
        return userService.updateUser(new UpdateUserRequest(updateOwnerEmailRequest));
    }

    @RequestMapping("/updateOwnerPassword")
    public CommonResponse updateOwnerPassword(UpdateOwnerPasswordRequest updateOwnerPasswordRequest) {
        User user = userService.getUser(updateOwnerPasswordRequest.getId());
        User userByPassword = userService.getUserByUsernameAndPassword(user.getUsername(), updateOwnerPasswordRequest.getOldPassword());
        if (userByPassword == null) {
            return CommonResponse.errorResponse(Errors.OLD_PASSWORD_WRONG);
        }
        return userService.updateUser(new UpdateUserRequest(updateOwnerPasswordRequest));
    }
}
