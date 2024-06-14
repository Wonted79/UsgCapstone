package usg.capstone.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @GetMapping("/")
    public String index() {
        return "home";
    }
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "내이름");
        model.addAttribute("img", "static/image/파일명");
        return "hello";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/signin")
    public String signin(){
        return "signin";
    }
}
