package com.baobaotao.editor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext factory = new ClassPathXmlApplicationContext("com/baobaotao/editor/beans.xml");
	    Boss boss=(Boss) factory.getBean("boss");
	    System.out.println(boss.getCar().toString());
	}

}
