package ar.com.indexer.beans;

import java.io.Serializable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {

	/**
	 * 
	 */
	
	private static ApplicationContext context = null;
	
	public static ApplicationContext getContext(){
		if(context==null){
//			context = new ClassPathXmlApplicationContext("resources/beans.xml");
			
		}
		return context;
	}
	
	
	
}
