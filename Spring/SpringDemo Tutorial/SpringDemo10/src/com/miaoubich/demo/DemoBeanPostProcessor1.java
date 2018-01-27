package com.miaoubich.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class DemoBeanPostProcessor1 implements BeanPostProcessor, Ordered {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("processing bean1 instance after initialization(i.e just after init life cycle event) of: " + beanName);
		
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("processing bean1 instance BEFORE initialization(i.e after spring instantiates bean before init life cycle event ) of :"+ beanName);
		
		return bean;
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1;//1 indicates this bean will be executed secondly since the index is 1
	}

}
