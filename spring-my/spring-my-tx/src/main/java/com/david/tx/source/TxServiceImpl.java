package com.david.tx.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @author fanzunying
 * @date 2021/6/30 17:41
 */
@Service
public class TxServiceImpl implements TxService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private TransactionTemplate transactionTemplate;


	@Override

	public void testDemo() {
		String sql = "select * from t_user where id = ?";

		// 默认情况下：它就是使用的PreparedStatement，所以不用担心Sql注入问题的
		RowMapper<UserEntity> rowMapper = new BeanPropertyRowMapper<>(UserEntity.class);
		List<UserEntity> list = jdbcTemplate.query(sql, rowMapper, 1);
		UserEntity userEntity = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(list);
		System.out.println(userEntity);
	}

	@Override
//	@Transactional(rollbackFor = Exception.class)
	public void insert() {
		transactionTemplate.execute(status -> {
			System.out.println("status = " + status);
//			status.setRollbackOnly();
			String sql = "INSERT INTO test_demo.t_user (  name, age, rest_day,   deleted)\n" +
					"VALUES ( 'zhang22', 12, '3',   0);";

			int update = jdbcTemplate.update(sql);
			System.out.println("update = " + update);
			return "ok";
//			throw new RuntimeException("测试异常");
		});

	}


	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertTwo() {
		String sql = "INSERT INTO test_demo.t_user (  name, age, rest_day,   deleted)\n" +
				"VALUES ( 'zhang22', 12, '3',   0);";

		int update = jdbcTemplate.update(sql);
		System.out.println("update = " + update);
		throw new RuntimeException("测试异常");
	}


}
