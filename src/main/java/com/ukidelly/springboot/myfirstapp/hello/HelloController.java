package com.ukidelly.springboot.myfirstapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


    @GetMapping("/say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World";
    }


    @GetMapping("/say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        String sb = "<html>" +
                "<head>" +
                "<title>" +
                "My First Html Page" +
                "</title>" +
                "</head>" +
                "<body>" +
                "My First html Page with Body" +
                "</body>" +
                "</html>";

        return sb;
    }


    @GetMapping("/say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }
}
