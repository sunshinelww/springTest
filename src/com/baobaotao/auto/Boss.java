package com.baobaotao.auto;

public class Boss {

	private String name;
	private Car car;
	private Office office;

	/*public Boss(){
		
	}*/
	public Boss(String name,Car car,Office office){
		this.name=name;
		this.car=car;
		this.office=office;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

}
