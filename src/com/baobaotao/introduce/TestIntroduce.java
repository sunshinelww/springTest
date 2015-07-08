package com.baobaotao.introduce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIntroduce {

	public static void main(String[] args){
		
		String configPath="com/baobaotao/introduce/beans.xml";
		ApplicationContext ctx=new ClassPathXmlApplicationContext(configPath);
		
		ForumService forumService=(ForumService)ctx.getBean("forumService");
		
		forumService.removeForum(200);
		forumService.removeTopic(1022);
		
		Monitorable monitorable=(Monitorable)forumService;
		monitorable.setMonitorActive(true);
		
		forumService.removeForum(200);
		forumService.removeTopic(1022);
	}
}
