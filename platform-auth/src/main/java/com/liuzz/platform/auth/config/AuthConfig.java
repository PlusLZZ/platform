package com.liuzz.platform.auth.config;

import com.liuzz.platform.auth.filter.LoginFilter;
import com.liuzz.platform.common.constants.WebFilterOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.PathMatcher;

import javax.servlet.Filter;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class AuthConfig {

    private final PathMatcher pathMatcher;

    public static <T extends Filter> FilterRegistrationBean<T> createFilterBean(T filter, Integer order) {
        FilterRegistrationBean<T> bean = new FilterRegistrationBean<>(filter);
        bean.setOrder(order);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilter() {
        log.debug("===== 登录验证过滤器加载,order:{} =====", WebFilterOrder.AUTH_FILTER);
        return createFilterBean(new LoginFilter(pathMatcher), WebFilterOrder.AUTH_FILTER);
    }

}
