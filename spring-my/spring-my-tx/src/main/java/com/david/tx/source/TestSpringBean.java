//package com.david.tx.source;
//
//
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ComponentScan
//public class TestSpringBean {
//
//	@Autowired
//	private  DataSource dataSource;
//
//	public static void main(String[] args) {
//		System.out.println( ); // com.mysql.jd
//	}
//
//
//
//	@Test
//	public void test1() throws SQLException {
//		System.out.println(dataSource); // com.mysql.jdbc.jdbc2.optional.MysqlDataSource@650eab8
//		System.out.println(dataSource.getConnection()); // com.mysql.jdbc.JDBC4Connection@72bc6553
//
////		System.out.println(jdbcTemplate); //org.springframework.jdbc.core.JdbcTemplate@66982506
////		System.out.println(namedParameterJdbcTemplate); //org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate@70cf32e3
//	}
//}
