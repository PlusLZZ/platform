package com.liuzz.platform.framework.web;

import com.liuzz.platform.framework.web.exception.GlobalExceptionHandler;
import com.liuzz.platform.framework.web.filter.ApiFilter;
import com.liuzz.platform.framework.web.filter.CacheRequestBodyFilter;
import com.liuzz.platform.common.constants.WebFilterOrder;
import com.liuzz.platform.framework.web.filter.TraceFilter;
import com.liuzz.platform.utils.date.DatePattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@EnableAsync
@AutoConfiguration
@Slf4j
public class WebAutoConfiguration implements WebMvcConfigurer {

    /**
     * 创建 CorsFilter Bean，解决跨域问题
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterBean() {
        // 创建 CorsConfiguration 对象
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*"); // 设置访问源地址
        config.addAllowedHeader("*"); // 设置访问源请求头
        config.addAllowedMethod("*"); // 设置访问源请求方法
        // 创建 UrlBasedCorsConfigurationSource 对象
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // 对接口配置跨域设置
        log.debug("===== 跨域配置加载 =====");
        return createFilterBean(new CorsFilter(source), WebFilterOrder.START);
    }

    /**
     * 创建 RequestBodyCacheFilter Bean，可重复读取请求内容
     */
    @Bean
    public FilterRegistrationBean<CacheRequestBodyFilter> requestBodyCacheFilter() {
        log.debug("===== 请求流可重复读Filter加载,order:{} =====",WebFilterOrder.REQUEST_BODY_CACHE_FILTER);
        return createFilterBean(new CacheRequestBodyFilter(), WebFilterOrder.REQUEST_BODY_CACHE_FILTER);
    }

    @Bean
    public FilterRegistrationBean<TraceFilter> traceFilter() {
        log.debug("===== TraceId链路追踪Filter加载,order:{} =====",WebFilterOrder.TRACE_FILTER);
        return createFilterBean(new TraceFilter(), WebFilterOrder.TRACE_FILTER);
    }

    @Bean
    public FilterRegistrationBean<ApiFilter> apiFilter() {
        log.debug("===== 接口API通用Filter加载,order:{} =====",WebFilterOrder.API_FILTER);
        return createFilterBean(new ApiFilter(), WebFilterOrder.API_FILTER);
    }

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        log.debug("===== RestControllerAdvice 错误处理器加载 =====");
        return new GlobalExceptionHandler();
    }

    /**
     * 增加get请求参数中时间类型转换
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setTimeFormatter(DatePattern.NORM_TIME_FORMATTER);
        registrar.setDateFormatter(DatePattern.NORM_DATE_FORMATTER);
        registrar.setDateTimeFormatter(DatePattern.NORM_DATETIME_FORMATTER);
        registrar.registerFormatters(registry);
    }

    public static <T extends Filter> FilterRegistrationBean<T> createFilterBean(T filter, Integer order) {
        FilterRegistrationBean<T> bean = new FilterRegistrationBean<>(filter);
        bean.setOrder(order);
        return bean;
    }



    /**
     * 创建 RestTemplate 实例
     *
     * @param restTemplateBuilder {@link RestTemplateAutoConfiguration#restTemplateBuilder}
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        log.debug("===== RestTemplate 自动加载 =====");
        return restTemplateBuilder.build();
    }

}
