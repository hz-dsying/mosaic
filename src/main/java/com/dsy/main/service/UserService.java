package com.dsy.main.service;

import com.dsy.main.pojo.User;

public interface UserService {
	/**
	 * 通过用户名和密码查找用户
	 * @param username
	 * @param password
	 * @return
	 */
	User findByUsernameAndPwd(String username, String password);

}
