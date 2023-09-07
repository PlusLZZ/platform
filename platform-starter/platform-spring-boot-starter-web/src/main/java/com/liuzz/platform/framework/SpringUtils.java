package com.liuzz.platform.framework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@Lazy(false)
public class SpringUtils implements ApplicationContextAware, DisposableBean {

    private static ApplicationContext applicationContext;

    private static Environment environment;

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static Environment getEnvironment() {
        return environment;
    }


    @Override
    public void destroy() throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("清除SpringUtils");
        }
        applicationContext = null;
        environment = null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
        environment = applicationContext.getEnvironment();
        log.debug("===== SpringUtils 自动加载 =====");
    }

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    /**
     * 获取BeanMap
     * @param requiredType 类型class
     * @return Map
     * @param <T> T
     */
    public static <T> Map<String, T> getBeanMap(Class<T> requiredType) {
        return applicationContext.getBeansOfType(requiredType);
    }

    /**
     * 获取BeanList
     * @param requiredType 类型class
     * @return List
     * @param <T> T
     */
    public static <T> Collection<T> getBeanList(Class<T> requiredType) {
        return applicationContext.getBeansOfType(requiredType).values();
    }

    /**
     * 发布事件
     * @param event event
     */
    public static void publishEvent(ApplicationEvent event) {
        if (applicationContext == null) {
            return;
        }
        applicationContext.publishEvent(event);
    }

}
