package com.baobaotao.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.beanfactory.Car;

public class BeanLifeCycle {

	public static void main(String[] args) throws Exception{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/baobaotao/context/beans.xml");
		Car car=(Car) ctx.getBean("car");
		car.introduce();
		car.destroy();
	}
}
