package com.nexign.springMessageSender.beanFactory;


import com.nexign.springMessageSender.annotation.Inject;
import com.nexign.springMessageSender.context.ApplicationContext;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class BeanFactory {

    private ApplicationContext context;
    public BeanFactory(ApplicationContext context) {
        this.context = context;
    }




    public <T> T getBean(Class<T> tClass) {
        Class<? extends T> implClass = tClass;
        if (implClass.isInterface()) {
            implClass = getImpl(implClass);
        }
        T bean = null;
        try {
            bean = implClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        Field[] fields = implClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                try {
                    field.set(bean, context.getBean(field.getType()));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bean;
    }

    public <T> Class<? extends T> getImpl(Class<T> tClass) {
        Reflections scanner = new Reflections("com.nexign.springMessageSender");
        Set<Class<? extends T>> subTypesOf = scanner.getSubTypesOf(tClass);
        if (subTypesOf.size() != 1) {
            throw new RuntimeException("0 more impls");
        }
        return subTypesOf.iterator().next();
    }

}
