package com.david.demo.source.reader.bean.b;

import com.david.demo.source.reader.bean.OrderService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author fanzunying
 * @date 2021/5/19 13:13
 */
@Configuration(value = "MyConfig")
@Import(OrderService.class)
public class MyConfig {
	private String name = "aaa";
}
