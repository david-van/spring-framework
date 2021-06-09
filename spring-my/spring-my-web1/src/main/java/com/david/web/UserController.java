package com.david.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// Controller使用@Controller标记而不是@Component:
@Controller
public class UserController {
    // 正常使用@Autowired注入:


    // 处理一个URL映射:
    @GetMapping("/test")
    public ModelAndView index() {
        System.out.println("idexc");
        return new ModelAndView("aaa", HttpStatus.OK);
    }

    @GetMapping("/test2")
    public String test2() {
        System.out.println("test2");
        return "ok";
    }

}