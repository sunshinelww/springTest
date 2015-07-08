package com.baobaotao.proxy;

public class TestForumService {

	public static void main(String[] args){
		ForumService forumService=new ForumServiceImpl();
		forumService.removeTopic(10);
		forumService.removeForum(1012);
		ClassLoader classLoader=forumService.getClass().getClassLoader();
	    System.out.println(classLoader);
	    Class<?>[] interfaces= forumService.getClass().getInterfaces();
	    for(Class<?> interface_i :interfaces){
	    	System.out.println(interface_i);
	    }
	}
}
