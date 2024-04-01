package com.nexign.springMessageSender.context;

import com.nexign.springMessageSender.beanFactory.BeanFactory;

import java.util.HashMap;
import java.util.Map;


public class ApplicationContext {
    private final Map<Class<?>, Object> cache = new HashMap<>();

    private BeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public <T> T getBean(Class<T> tClass) {
        if (cache.containsKey(tClass)) {
            return (T) cache.get(tClass);
        }

        T bean = beanFactory.getBean(tClass);
        cache.put(tClass, bean);
        return bean;
    }
}
