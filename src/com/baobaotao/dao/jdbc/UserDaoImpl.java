package com.baobaotao.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.baobaotao.dao.UserDao;
import com.baobaotao.domain.User;

public class UserDaoImpl implements UserDao{

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate=jdbcTemplate;
	}
	@Override
	public int getMatchCount(String userName, String password) {
		// TODO Auto-generated method stub
		
		String sqlStr="select count(*) from tb_user where userName=? and password=?";
		return jdbcTemplate.queryForInt(sqlStr,new Object[]{userName,password});
	}

	@Override
	public User findUserbyUserName(String userName) {
		// TODO Auto-generated method stub
		String sqlStr="select userId,userName,credits from tb_user where userName=?";
		final User user=new User();
		jdbcTemplate.query(sqlStr, new Object[]{userName},
				new RowCallbackHandler(){

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						// TODO Auto-generated method stub
						user.setUserId(rs.getInt("userId"));
						user.setUserName(rs.getString("userName"));
						user.setCredits(rs.getInt("credits"));
					}
			
		});
		return user;
	}

	@Override
	public void updateLoginInfo(User user) {
		// TODO Auto-generated method stub
		String sqlStr="update tb_user set lastVist=?,lastIp=?,credits=? where userId=?";
		jdbcTemplate.update(sqlStr, new Object[]{user.getLastVist(),
				     user.getLastIp(),user.getCredits(),user.getUserId()});
	}

}
