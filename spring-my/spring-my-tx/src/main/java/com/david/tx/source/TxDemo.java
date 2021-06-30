package com.david.tx.source;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author fanzunying
 * @date 2021/6/30 17:31
 */
@ComponentScan
public class TxDemo {
	public static void main(String[] args) throws SQLException {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(TxDemo.class);
		context.refresh();

		DataSource dataSource = context.getBean(DataSource.class);
//		for (int i = 0; i < 5; i++) {
//			Connection connection = dataSource.getConnection();
//			System.out.println("connection = " + connection);
//			connection.close();
//		}

		TxService txService = context.getBean(TxService.class);
//		txService.testDemo();
		txService.insert();
	}
}
