package com.baobaotao.tagdepend;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainApplication {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Resource res=new ClassPathResource("com/baobaotao/tagdepend/beans.xml");
		BeanFactory bf=new XmlBeanFactory(res);
		
		Boss boss=(Boss) bf.getBean("boss");
		System.out.println(boss.getCarId().toString());
		
	}

}
