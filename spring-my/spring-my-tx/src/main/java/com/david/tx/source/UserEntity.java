package com.david.tx.source;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author fanzunying
 * @date 2021/6/30 17:43
 */
@Data
public class UserEntity {
	private Long id;
	private String name;
	private Integer age;
	private String restDay;
	private Date creationTime;
	private LocalDateTime updatedTime;
	private Boolean deleted;


}
