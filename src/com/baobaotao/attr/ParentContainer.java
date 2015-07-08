package com.baobaotao.attr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ParentContainer {

	private static void RefBean(){
		ClassPathXmlApplicationContext pFactory=new ClassPathXmlApplicationContext(
				new String[]{"com/baobaotao/attr/beans.xml"});
		//ApplicationContext factory=new ClassPathXmlApplicationContext(new String[]{"com/baobaotao/attr/beans2.xml"},pFactory);
	    Boss boss=(Boss)pFactory.getBean("boss1");
	    System.out.println(boss.toString());
	   // System.out.println(boss.getFavorites().get(0).toString());
	}
	
	public static void main(String[] args){
		RefBean();
	}
}
