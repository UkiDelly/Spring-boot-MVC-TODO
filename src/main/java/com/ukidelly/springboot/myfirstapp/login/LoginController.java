package com.ukidelly.springboot.myfirstapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @GetMapping
    public String loginView(Model model, @RequestParam String name) {
        logger.warn("name : {}", name);

        // thymeleaf model에 name 값 추가
        model.addAttribute("name", name);

        return "login";
    }

}
