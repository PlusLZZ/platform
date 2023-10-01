package com.liuzz.platform.auth.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.liuzz.platform.common.constants.HeaderKey;
import com.liuzz.platform.utils.array.CollectionUtils;
import com.liuzz.platform.utils.string.StringUtils;

import javax.imageio.metadata.IIOMetadataFormat;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 权限系统上下文
 */
public class AuthContext {


    private static final TransmittableThreadLocal<AuthContextModel> CONTEXT = new TransmittableThreadLocal<>();

    public static AuthContextModel get(){
        return CONTEXT.get();
    }

    /**
     * 必须init,后续不再处理空指针问题
     */
    public static void init(){
        CONTEXT.set(new AuthContextModel());
    }

    /**
     * 调用完毕需要移除上下文
     */
    public static void clear(){
        CONTEXT.remove();
    }

    /**
     * 初始化一些数据到上下文
     */
    public static void handle(HttpServletRequest request){
        if (request != null){
            AuthContextModel contextModel = CONTEXT.get();
            Map<String,String> paramMap = new HashMap<>();
            Map<String,String> headerMap = new HashMap<>();
            contextModel.setUri(request.getRequestURI());
            request.getParameterMap().forEach((key,value)->{
                if (value != null && value.length > 0){
                    paramMap.put(key, CollectionUtils.join(",",value));
                }
            });
            String authorization = request.getHeader(HeaderKey.AUTHORIZATION);
            if (StringUtils.isNotBlank(authorization)){
                headerMap.put(HeaderKey.AUTHORIZATION,authorization);
            }

            contextModel.setHeaderMap(headerMap);
            contextModel.setParamMap(paramMap);
        }
    }

}
