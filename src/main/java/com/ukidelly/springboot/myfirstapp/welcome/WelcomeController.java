package com.ukidelly.springboot.myfirstapp.welcome;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("username")
public class WelcomeController {


    @GetMapping
    public String welcome(Model model) {
        model.addAttribute("message", "admin");
        model.addAttribute("username", getLoggedInUsername());
        return "welcome";
    }

    // Authentication에서 유저이름 가져오기
    private String getLoggedInUsername() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
