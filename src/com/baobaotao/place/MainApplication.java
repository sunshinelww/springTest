package com.baobaotao.place;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.baobaotao.tagdepend.Boss;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Resource res=new ClassPathResource("com/baobaotao/place/beans.xml");
		BeanFactory bf=new XmlBeanFactory(res);
		  
		Car car=(Car) bf.getBean("car");
		System.out.println(car.toString());
	}
}
