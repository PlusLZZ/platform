package com.liuzz.platform.common.constants;

/**
 * 各个过滤器的顺序
 * Spring Security Filter 默认为 -100，可见 org.springframework.boot.autoconfigure.security.SecurityProperties 配置属性类
 */
public class WebFilterOrder {

    /**
     * 最开始请求  CORS
     */
    public static final int START = Integer.MIN_VALUE;

    /**
     * traceId 过滤器
     */
    public static final int TRACE_FILTER = START + 1;

    /**
     * API请求等数据记录 过滤器
     */
    public static final int API_FILTER = START + 2;

    /**
     * 请求内容可重复读过滤器
     */
    public static final int REQUEST_BODY_CACHE_FILTER = START + 100;

    /**
     * 登录权限过滤器
     */
    public static final int AUTH_FILTER = START + 200;


    /**
     * 最后请求
     */
    public static final int END = Integer.MAX_VALUE;

}
