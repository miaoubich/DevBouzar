package com.miaoubich.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class DemoBeanPostProcessor2 implements BeanPostProcessor, Ordered{//ordered: used to call DemoBeanPostProcessor2 before DemoBeanPostProcessor1

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("processing bean2 instance after initialization(i.e just after init life cycle event) of: " + beanName);
		
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("processing bean2 instance BEFORE initialization(i.e after spring instantiates bean before init life cycle event ) of :"+ beanName);
		
		return bean;
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;//o indicate first index which means this bean will be executed first
	}

}
