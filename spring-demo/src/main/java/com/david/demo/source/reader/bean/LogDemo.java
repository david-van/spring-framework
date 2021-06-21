package com.david.demo.source.reader.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author fanzunying
 * @date 2021/6/17 11:33
 */
public class LogDemo {
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger();
		logger.trace("trace");
		logger.debug("aaa");
		logger.info("info");
		logger.error("error");
	}
}
