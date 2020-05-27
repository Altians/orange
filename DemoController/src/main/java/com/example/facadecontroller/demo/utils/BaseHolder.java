package com.example.facadecontroller.demo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 获取ApplicationContext对象
 * @date 2019/11/20 10:50
 * 也可以继承ApplicationObjectSupport 因为它实现了aware接口
 */
@Component
public class BaseHolder implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public static <T> T getBeanName(String beanName){

        return (T) context.getBean(beanName);
    }
}
