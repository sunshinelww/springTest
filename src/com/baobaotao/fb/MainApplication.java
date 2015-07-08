package com.baobaotao.fb;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.baobaotao.tagdepend.Boss;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Resource res=new ClassPathResource("com/baobaotao/fb/beans.xml");
		BeanFactory bf=new XmlBeanFactory(res);
		
		Car car=(Car) bf.getBean("car");
		System.out.println(car.toString());
		
		List list=(List) bf.getBean("favoriteList");
		System.out.println(list.size());
	}
}
