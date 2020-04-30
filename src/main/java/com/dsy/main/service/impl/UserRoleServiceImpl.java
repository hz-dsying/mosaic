package com.dsy.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.main.dao.UserRoleMapper;
import com.dsy.main.pojo.UserRoleExample;
import com.dsy.main.pojo.UserRoleKey;
import com.dsy.main.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public void deleteByUser(Integer userid) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUseridEqualTo(userid);
		userRoleMapper.deleteByExample(example );
	}

	@Override
	public void insert(UserRoleKey userRole) {
		userRoleMapper.insert(userRole);
		
	}

}
