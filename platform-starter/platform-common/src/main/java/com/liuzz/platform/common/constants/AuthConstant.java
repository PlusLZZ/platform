package com.liuzz.platform.common.constants;

import java.util.Arrays;
import java.util.List;

/**
 * 权限中心常量
 * <a href="https://zhuanlan.zhihu.com/p/375154660">...</a>
 * <a href="https://www.ruanyifeng.com/blog/2019/04/oauth-grant-types.html">...</a>
 */
public class AuthConstant {

    /**
     * 授权码获取 url
     */
    public static final String AUTHORIZE_URL = "/oauth/authorize";

    /**
     * 授权码获取 token
     */
    public static final String AUTH_TOKEN_URL = "/oauth/token";

    /**
     * 授权码获取 token
     */
    public static final String TOKEN_URL = "/token";

    /**
     * 需要进行权限拦截器处理的地址
     */
    public static final List<String> FILTER_URLS = Arrays.asList(AUTHORIZE_URL,AUTH_TOKEN_URL,TOKEN_URL);

}
