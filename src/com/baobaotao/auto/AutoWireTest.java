package com.baobaotao.auto;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireTest {

	private static void autoWire(){
		ClassPathXmlApplicationContext pFactory=new ClassPathXmlApplicationContext(
				new String[]{"com/baobaotao/auto/beans.xml"});
		Boss boss=(Boss) pFactory.getBean("boss");
		System.out.println(boss.getCar().getBrand());
		
	}
	public static void main(String[] args){
		autoWire();
	}
}
