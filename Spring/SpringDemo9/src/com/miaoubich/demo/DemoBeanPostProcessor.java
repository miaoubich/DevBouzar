package com.miaoubich.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DemoBeanPostProcessor implements BeanPostProcessor{
	
	@Override
	 public Object postProcessAfterInitialization(Object bean, String BeanName) throws BeansException {
	  System.out.println("processing bean instance after initialization (i.e. just after init life cycle event ) of : " + BeanName);
	  return bean;
	 }

	 @Override
	 public Object postProcessBeforeInitialization(Object bean, String BeanName) throws BeansException {
	  System.out.println("processing bean instance before initialization ( i.e. after spring instantites bean and before init life cycle event ) of :" + BeanName);
	  return bean;
	 }

}
