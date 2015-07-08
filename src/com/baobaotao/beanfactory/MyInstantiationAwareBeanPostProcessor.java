package com.baobaotao.beanfactory;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/**
 * 后处理器
 * @author Weiwei Li
 *
 */
public class MyInstantiationAwareBeanPostProcessor extends 
      InstantiationAwareBeanPostProcessorAdapter{

	/**
	 * 实例化Bean后调用
	 */
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		if("car".equals(beanName)){
			System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
		}
		return true;
	}


   /**
    * 在实例化Bean前调用
    */
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass,
			String beanName) throws BeansException {
		// TODO Auto-generated method stub
		if("car".equals(beanName)){
			System.out.println("InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
		}
		return null;
	}


    /**
     * 在设置某个属性时调用
     */
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs,
			PropertyDescriptor[] pds, Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		if("car".equals(beanName)){
			System.out.println("InstantiationAwareBeanPostProcessor.postProcessPropertyValues");
		}
		return pvs;
	}
	
	
}
