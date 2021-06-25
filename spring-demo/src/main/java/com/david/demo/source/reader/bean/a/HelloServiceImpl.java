package com.david.demo.source.reader.bean.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author fanzunying
 * @date 2021/6/25 15:59
 */
@Service
public class HelloServiceImpl implements HelloService {
	@Autowired
	private HelloService helloService;

	@PostConstruct
	public void hello() {
		System.out.println("helloService.getClass() = " + helloService.getClass());
		System.out.println("helloService = " + helloService);
	}

}
