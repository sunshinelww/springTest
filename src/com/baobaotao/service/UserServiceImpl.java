package com.baobaotao.service;

import com.baobaotao.dao.LoginLogDao;
import com.baobaotao.dao.UserDao;
import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	private LoginLogDao loginLogDao;
	
	@Override
	public boolean hasMatchUser(String userName, String password) {
		// TODO Auto-generated method stub
		int matchCount=userDao.getMatchCount(userName, password);
		return matchCount>0;
	}

	@Override
	public User findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.findUserbyUserName(userName);
	}

	@Override
	public void loginSuccess(User user) {
		// TODO Auto-generated method stub
		user.setCredits(5+user.getCredits());
		LoginLog loginLog=new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVist());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
		
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setLoginLogDao(LoginLogDao loginLogDao) {
		this.loginLogDao = loginLogDao;
	}
	

}
