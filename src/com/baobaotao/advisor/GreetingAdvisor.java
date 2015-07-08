package com.baobaotao.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

/**
 * 定义切面类，包括
 * @author Administrator
 *
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor{

	@Override
	public boolean matches(Method method, Class targetClass) {
		// TODO Auto-generated method stub
		return "greetTo".equals(method.getName());
	}

	@Override
	public ClassFilter getClassFilter() {
		// TODO Auto-generated method stub
		return new ClassFilter(){

			@Override
			public boolean matches(Class<?> clazz) {
				// TODO Auto-generated method stub
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}

	
	
}
