package com.baobaotao.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {

	public static void main(String[] args){
		Resource res=new ClassPathResource("com/baobaotao/beanfactory/beans.xml");
		BeanFactory bf=new XmlBeanFactory(res);
		Car car=(Car)bf.getBean("car");
		car.introduce(); 
	}
}
