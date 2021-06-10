package com.david.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// Controller使用@Controller标记而不是@Component:
@Controller
@RequestMapping("role")
public class RoleController {
	// 正常使用@Autowired注入:


	// 处理一个URL映射:
	@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView index() {
		System.out.println("idexc");
		return new ModelAndView("aaa", HttpStatus.OK);
	}

	@RequestMapping(value = "/test")
	public String test2() {
		System.out.println("test2");
		return "ok";
	}

}