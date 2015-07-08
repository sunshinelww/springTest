package com.baobaotao.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory bf)
			throws BeansException {
		// TODO Auto-generated method stub
		BeanDefinition bd=bf.getBeanDefinition("car");
		
		bd.getPropertyValues().add("brand", "奇瑞QQ");
		System.out.println("调用BeanFactoryPostProcessor.postProcessBeanFactoryFactory()");
	}
	

	
}
