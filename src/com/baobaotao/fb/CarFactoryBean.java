package com.baobaotao.fb;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean {

	private String carInfo;

	@Override
	public Object getObject() throws Exception {
		// TODO Auto-generated method stub
		Car car=new Car();
		String[] infos=carInfo.split(",");
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.parseInt(infos[1]));
		car.setPrice(Double.parseDouble(infos[2]));
		return car;
	}

	@Override
	public Class getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}
	
}
