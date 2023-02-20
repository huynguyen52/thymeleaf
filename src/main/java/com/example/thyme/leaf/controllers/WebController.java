package com.example.thyme.leaf.controllers;

import com.example.thyme.leaf.data.Info;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    /*
     * Model là một object của Spring Boot, được gắn vào trong mọi request.
     */
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "", required = false) String name, Model model) {
        // Gắn vào model giá trị name nhận được
        model.addAttribute("name", name);

        // Model ở đây là một object được Spring Boot đính kém trong mỗi response.
        // Model chứa các thông tin mà bạn muốn trả về và Template Engine sẽ trích xuất thông tin này ra thành html và đưa cho người dùng.
        return "hello";  // trả về file hello.html cùng với thông tin trong object Model
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        List<Info> profile = new ArrayList<>();
        profile.add(new Info("fullname", "Nguyen Van A"));
        profile.add(new Info("nickname", "alice"));

        model.addAttribute("profile", profile);
        return "profile";
    }
}
