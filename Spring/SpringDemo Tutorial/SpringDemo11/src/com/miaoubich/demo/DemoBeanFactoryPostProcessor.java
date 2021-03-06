package com.miaoubich.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DemoBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		BeanDefinition beandefinition = beanFactory.getBeanDefinition("restoBean");
		MutablePropertyValues PropertyValues = beandefinition.getPropertyValues();
		
		PropertyValues.addPropertyValue("welcomeNote", "This is a modified welcomeNote using BeanFactoryPostProcessor !");
		
	}

}
