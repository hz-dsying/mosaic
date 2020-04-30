package com.dsy.main.service;

import com.dsy.main.pojo.UserRoleKey;

public interface UserRoleService {

	/**
	 * 根据用户删除记录
	 * @param userid
	 */
	void deleteByUser(Integer userid);

	/**
	 * 注册用户时插入记录
	 * @param userRole
	 */
	void insert(UserRoleKey userRole);

}
