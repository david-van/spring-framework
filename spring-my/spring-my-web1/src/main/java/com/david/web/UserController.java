package com.david.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;

// Controller使用@Controller标记而不是@Component:
@Controller
@RequestMapping("user")
public class UserController {
	// 正常使用@Autowired注入:


	// 处理一个URL映射:
	@PostMapping("/test")
	public ModelAndView index(@RequestBody String input) {
		StreamingResponseBody responseBody = new StreamingResponseBody() {
			@Override
			public void writeTo(OutputStream outputStream) throws IOException {

			}
		};
		System.out.println("idexc");
		return new ModelAndView("aaa", HttpStatus.OK);
	}

	@GetMapping(value = "/test2", params = {"myParam=myValue"})
	@ModelAttribute
	public String test2(@MatrixVariable String info) {
		System.out.println("test2");
		return "ok";
	}

}