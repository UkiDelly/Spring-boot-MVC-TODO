package com.ukidelly.springboot.myfirstapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@SessionAttributes("username")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String loginView() {
        return "login";
    }

    @PostMapping
    public String login(Model model, @RequestParam String username, @RequestParam String password) {

        if (authenticationService.authenticate(username, password)) {
            logger.info("Login Successful");
            model.addAttribute("username", username);
            return "welcome";
        }

        logger.warn("Login Failed");
        model.addAttribute("errorMessage", "Invalid Credentials");
        return "login";
    }

}
