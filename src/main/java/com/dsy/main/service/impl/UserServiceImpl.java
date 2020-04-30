package com.dsy.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.main.dao.UserMapper;
import com.dsy.main.pojo.User;
import com.dsy.main.pojo.UserExample;
import com.dsy.main.service.UserService;
import com.dsy.main.util.LoginException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findByUsernameAndPwd(String username, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<User> list = userMapper.selectByExample(example);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}else {
			throw new LoginException("用户名/密码错误");
		}
	}

	@Override
	public User selectByUsername(String username) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public void addUser(User user) {
		userMapper.insert(user);
//		userMapper.insertSelective(user);
		
	}

	@Override
	public User selectByUsernameAndPwd(String username, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<User> list = userMapper.selectByExample(example);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<User> queryAllUser() {
		UserExample example = new UserExample();
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

	@Override
	public void deleteById(Integer userid) {
		userMapper.deleteByPrimaryKey(userid);
	}

	@Override
	public List<User> selectByName(String username) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameLike(username);
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

	

	
}
