package com.david.demo.source.reader.async;

import java.util.concurrent.Future;

/**
 * @author fanzunying
 * @date 2021/6/24 16:43
 */
public interface HelloDemo {
	String getInfo();

	Future<String> getInfoAsync()  ;

	String getMyInfo();
}
