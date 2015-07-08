package com.baobaotao.dao.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import com.baobaotao.dao.LoginLogDao;
import com.baobaotao.domain.LoginLog;

public class LoginLogDaoImpl implements LoginLogDao{
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertLoginLog(LoginLog loginLog) {
		// TODO Auto-generated method stub
		String sqlStr="insert into tb_login_log (userId,ip,loginDatetime) "+
		              "values(?,?,?);";
		Object[] args={loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()};
		jdbcTemplate.update(sqlStr, args);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

}
