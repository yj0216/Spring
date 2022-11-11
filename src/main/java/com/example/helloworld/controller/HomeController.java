package com.example.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//우선순위 컨트롤러 > 정적 페이지
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
