package cc.doctor.lovely.blog.service;

import cc.doctor.lovely.blog.controller.request.UserRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public void setUserRequest(UserRequest userRequest) {
        String accessToken = userRequest.getAccessToken();

    }
}
