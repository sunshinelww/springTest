package com.baobaotao.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class BeanLifeCycle {

	private static void LifeCycleInBeanFactory(){
		/**
		 * 资源类初始化，从类路径下加载配置文件
		 */
		Resource res=new ClassPathResource("com/baobaotao/beanfactory/beans.xml");
		//启动IoC容器
		BeanFactory bf=new XmlBeanFactory(res);
		
		//向容器中注册中MyBeanPostProcessor后处理器
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(
				new MyBeanPostProcessor());
		
		//向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(
				new MyInstantiationAwareBeanPostProcessor());
	
		/**
		 * 第一次从容器中获取car,将触发容器实例化该Bean,这将引发Bean生命周期方法的调用
		 */
		Car car1=(Car)bf.getBean("car");
		car1.introduce();
		car1.setColor("红色");
		
		//第二次从容器中获取car，直接从缓冲池中获取
		Car car2=(Car)bf.getBean("car");
		
		//查看car1与car2是否指向同一引用
		System.out.println("car1==car2："+(car1==car2));
		
		//关闭容器
		((XmlBeanFactory)bf).destroySingletons();
	}
	
	public static void main(String[] args){
		LifeCycleInBeanFactory();
	}
}
