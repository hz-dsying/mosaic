package com.dsy.main.service;

import java.util.List;

import com.dsy.main.pojo.User;

public interface UserService {
	/**
	 * 登录时通过用户名和密码查找用户
	 * @param username
	 * @param password
	 * @return
	 */
	User findByUsernameAndPwd(String username, String password);

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User selectByUsername(String username);

	/**
	 * 添加用户
	 * @param user
	 */
	void addUser(User user);

	/**
	 * 通过用户名和密码查找用户
	 * @param username
	 * @param password
	 * @return
	 */
	User selectByUsernameAndPwd(String username, String password);

	/**
	 * 修改用户信息
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> queryAllUser();

	/**
	 * 删除用户
	 * @param userid
	 */
	void deleteById(Integer userid);

	/**
	 * 根据用户名模糊查找用户
	 * @param username
	 * @return
	 */
	List<User> selectByName(String username);
	

}
