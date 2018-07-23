package cc.doctor.lovely.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AttentionController {
    @RequestMapping("attention")
    public Object attention() {
        return null;
    }


    @RequestMapping("unAttention")
    public Object unAttention() {
        return null;
    }

    @RequestMapping("getFollowers")
    public Object getFollowers() {
        return null;
    }

    @RequestMapping("getAttentions")
    public Object getAttentions() {
        return null;
    }
}
