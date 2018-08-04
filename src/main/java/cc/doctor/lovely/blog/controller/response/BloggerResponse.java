package cc.doctor.lovely.blog.controller.response;

import lombok.Data;

import java.util.Date;

@Data
public class BloggerResponse {
    private Integer id;

    private Integer userId;

    private String username;

    private String header;

    private Byte gender;

    private Date birthday;

    private String address;

    private String company;

    private String position;

    private Byte marriageStatus;

    private String mobile;

    private String email;

    private String qq;

    private String github;

    private String weibo;

    private String facebook;

    private String twitter;

    private Byte isDeleted;

    private Date createdAt;

    private Date updatedAt;

    private Integer followerNum;

    private Integer attentionNum;
}
