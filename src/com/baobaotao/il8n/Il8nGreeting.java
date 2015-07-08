package com.baobaotao.il8n;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Il8nGreeting {

	private static void ResouceBundleDemo(){
		ResourceBundle rb1=ResourceBundle.getBundle("com/baobaotao/il8n/fmt_resource",Locale.US);
	    ResourceBundle rb2=ResourceBundle.getBundle("com/baobaotao/il8n/fmt_resource",Locale.CHINA);
	    Object[] params={"John",new GregorianCalendar().getTime()};
	    
	    String str1=new MessageFormat(rb1.getString("greeting.common"),Locale.CHINA).format(params);
	    String str2=new MessageFormat(rb2.getString("greeting.morning"),Locale.CHINA).format(params);
	    String str3=new MessageFormat(rb2.getString("greeting.afternoon"),Locale.US).format(params);
	    System.out.println(str1);
	    System.out.println(str2);
	    System.out.println(str3);
	}
	
	private static void ResourceBundleMessageSourceDemo(){
		String configs[]={"com/baobaotao/il8n/beans.xml"};
		ApplicationContext ctx=new ClassPathXmlApplicationContext(configs);
		
		MessageSource ms=(MessageSource)ctx.getBean("myResource");
		Object[] params={"John",new GregorianCalendar().getTime()};
		
		String str1=ms.getMessage("greeting.common", params, Locale.US);
		String str2=ms.getMessage("greeting.morning", params,Locale.CHINA);
		String str3=ms.getMessage("greeting.afternoon", params, Locale.CHINA);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
	}
	
	private static void ReloadableResourceBundleMessageSourceDemo() throws InterruptedException{
		String[] configs={"com/baobaotao/il8n/beans.xml"};
		ApplicationContext ctx=new ClassPathXmlApplicationContext(configs);
		
		MessageSource ms=(MessageSource)ctx.getBean("myResource2");
		Object[] params={"黎威威",new GregorianCalendar().getTime()};
		
		for(int i=0;i<2;i++){
			String str1=ms.getMessage("greeting.common", params, Locale.CHINA);
			System.out.println(str1);
			Thread.currentThread().sleep(20000);
		}
	}
	public static void main(String[] args){
		//ResouceBundleDemo();
		try {
			ReloadableResourceBundleMessageSourceDemo();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
