package com.baobaotao.editor;

import java.beans.PropertyEditorSupport;

public class CustomCarEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(text==null||text.indexOf(",")==-1){
			throw new IllegalArgumentException("设置字符串格式不正确");
		}
		String[] infos=text.split(",");
		Car car=new Car();
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.parseInt(infos[1]));
		car.setPrice(Double.parseDouble(infos[2]));
		setValue(car);
	}
}
