package com.david.tx.source;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.*;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author fanzunying
 * @date 2021/6/30 17:07
 */
@Configuration
@Order(0)
//@Component
public class TxConfig {
	// 此处只是为了演示 所以不用连接池了===========生产环境禁止这么使用==========
	@Bean
	public DataSource dataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("fzy130725");
		dataSource.setURL("jdbc:mysql://101.132.40.208:3306/test_demo");
		return dataSource;
	}

	//为了执行sql方便 此处采用JdbcTemplate进行===========
	// 生产环境一下一般我们不需要此配置，因为一般我们会使用ORM框架~
	// 但是如果是SpringBoot，这两个类默认都会配置上（导入了Spring-JDBC的jar即可）  比如MyBatis就是基于JDBC的
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	@Bean
	public PlatformTransactionManager getTransactionManager() {
		DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource());
		return manager;
	}

	@Bean
	public TransactionTemplate transactionTemplate() {
		//编程式事务管理
		TransactionTemplate transactionTemplate = new TransactionTemplate();
		transactionTemplate.setTransactionManager(getTransactionManager());
		return transactionTemplate;
	}

	// 自定义配置一个事务拦截器（@Transaction注解也会使用此拦截器进行拦截）
	//这里配置的bean不会被加载到拦截器中，因为同名覆盖的问题，
	@Bean
	@Order(value = 0)
	@Primary
	public TransactionInterceptor transactionInterceptor(PlatformTransactionManager transactionManager) {
		Map<String, TransactionAttribute> txMap = new HashMap<>();
		// required事务  适用于觉得部分场景~
		RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
		requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(RuntimeException.class)));
		requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		txMap.put("add*", requiredTx);
		txMap.put("save*", requiredTx);
		txMap.put("insert*", requiredTx);
		txMap.put("update*", requiredTx);
		txMap.put("delete*", requiredTx);

		// 查询 使用只读事务
		RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
		readOnlyTx.setReadOnly(true);
		readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
		txMap.put("get*", readOnlyTx);
		txMap.put("query*", readOnlyTx);

		// 定义事务属性的source~~~ 此处使用它  也就是根据方法名进行匹配的~~~
		NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
		source.setNameMap(txMap);

		TransactionInterceptor interceptor = new TransactionInterceptor();
		interceptor.setTransactionManager(transactionManager);
		interceptor.setTransactionAttributeSource(source);
		return interceptor;
	}


	//	@Bean
	public TransactionProxyFactoryBean transactionProxyFactoryBean(PlatformTransactionManager transactionManager) {
		TransactionProxyFactoryBean transactionProxyFactoryBean = new TransactionProxyFactoryBean();
		// 设置事务管理器  去管理这个Bean的事务关系
		transactionProxyFactoryBean.setTransactionManager(transactionManager);
		// 设置目标对象
		// 这里需要注意：这里设置了目标对象，你的HelloServiceImpl就不允许再交给Spring管理了  否则会有两个Bean，注入会报错的
		transactionProxyFactoryBean.setTarget(new TxServiceImpl());
		// 设置事务相关的属性：transactionAttributes
		Properties transactionAttributes = new Properties();
		transactionAttributes.setProperty("*", "PROPAGATION_REQUIRED");
		transactionProxyFactoryBean.setTransactionAttributes(transactionAttributes);

		return transactionProxyFactoryBean;
	}

}
