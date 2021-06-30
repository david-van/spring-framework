package com.david.tx.source;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author fanzunying
 * @date 2021/6/30 17:41
 */
public interface TxService {
	void testDemo();

	void insert();


	void insertTwo();
	void insertThree();
	void insertFour();
	void insertFive();

	void insertSix();
	void insertSeven();
	void insertEight();
}
