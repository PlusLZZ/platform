package com.liuzz.platform.auth.config;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.liuzz.platform.auth.context.AuthContextApi;
import com.liuzz.platform.auth.context.ContextApi;

/**
 * 权限系统上下文
 */
public class AuthContext {


    private static TransmittableThreadLocal<AuthContextApi> CONTEXT = new TransmittableThreadLocal<>();

    public static String getUserId() {
        return CONTEXT.get().getUserId();
    }
}
