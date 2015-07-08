package com.baobaotao.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 显示spring中bean的生命周期
 * @author Weiwei Li
 *
 */
public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,
             DisposableBean{

	private String brand;
	private String color;
	private int maxSpeed;
	private String iDCode;

	private BeanFactory beanFactory;
	private String beanName;
	
	public Car() {
		System.out.println("调用Car()构造函数。");
	}

	public Car(String brand, String color, int maxSpeed) {
		this.brand = brand;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	public void introduce() {
		System.out.println("brand:" + brand + ";color:" + color + ";maxSpeed"
				+ maxSpeed+";iDcode:"+this.iDCode);
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("调用setBrand()设置属性。");
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
		System.out.println("调用setColor()设置属性");
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("调用DisposableBean.destory()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("调用InitializingBean.afterPropertiesSet()。");
	}

	/**
	 * 将配置文件中该Bean对应的名称设置到Bean中
	 */
	@Override
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		this.beanName=beanName;
		System.out.println("调用BeanNameAware.setBeanName()方法");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("调用BeanFactoryAware.setBeanFactory()方法");
		this.beanFactory=beanFactory;
	}

	/**
	 * 通过init-method设置的初始化方法
	 */
	public void myInit(){
		System.out.println("调用init_method指定的myInit(),将maxSpeed设置为240。");
	    this.maxSpeed=240;
	}
	
	/**
	 * 通过destory-method属性配置的销毁方法
	 */
	public void myDestory(){
		System.out.print("调用destory-method所指定的myDestory().");
	}

	public String getIDCode() {
		return iDCode;
	}

	public void setIDCode(String iDCode) {
		this.iDCode = iDCode;
	}
	
}
