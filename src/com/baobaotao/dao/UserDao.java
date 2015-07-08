package com.baobaotao.dao;

import com.baobaotao.domain.User;

public interface UserDao {

	/**
	 * 验证用户名和密码
	 * @param userName
	 * @param password
	 * @return
	 */
	int getMatchCount(String userName,String password);
	/**
	 * 根据用户名获取User对象
	 * @param userName
	 * @return
	 */
	User findUserbyUserName(String userName);
	/**
	 * 更新用户登录信息
	 * @param user
	 */
	void updateLoginInfo(User user);
}
