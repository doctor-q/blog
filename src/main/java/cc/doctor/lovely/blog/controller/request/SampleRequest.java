package cc.doctor.lovely.blog.controller.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class SampleRequest implements Serializable {
    private static final long serialVersionUID = 6602833553601411453L;
    private Integer id;
    private String name;
    private String token;
}
