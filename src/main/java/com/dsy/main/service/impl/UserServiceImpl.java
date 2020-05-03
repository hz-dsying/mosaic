package com.dsy.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.main.dao.UserMapper;
import com.dsy.main.pojo.User;
import com.dsy.main.pojo.UserExample;
import com.dsy.main.service.UserService;
import com.dsy.main.util.LoginException;
import com.dsy.main.util.PageBean;

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

	@Override
	public User selectByUserid(Integer userid) {
		User user = userMapper.selectByPrimaryKey(userid);
		return user;
	}

	@Override
	public PageBean<User> findPageBean(String username, int currentPage, int pageSize) {
		UserExample example = new UserExample();
		// 1.通过数据库查询totalCount，所有的记录条数
		example.createCriteria().andUsernameLike(username);
		int totalCount = (int) userMapper.countByExample(example );
		// 2.创建PageBean对象
		PageBean<User> pb = new PageBean<User>(totalCount, currentPage, pageSize);
		// 3.查询用户列表
		List<User> list = userMapper.selectByExample(example);
		int m = currentPage * pageSize;
		if(m > list.size()) {
			m = list.size();
		}		
		List<User> list2 = list.subList((currentPage-1) * pageSize, m);
		// 4.将list拼接到pageBean中
		pb.setList(list2);
		// 5.返回完整的pageBean对象
		return pb;
	}

	

	
}
