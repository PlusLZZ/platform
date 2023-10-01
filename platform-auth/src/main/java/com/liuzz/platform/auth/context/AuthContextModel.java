package com.liuzz.platform.auth.context;


import lombok.Data;

import java.util.Map;

@Data
public class AuthContextModel {

    /**
     * 请求uri
     */
    private String uri;

    /**
     * 授权模式(四种模式)
     */
    private String authorizationMode;

    /**
     * 入参列表(queryString与body)
     */
    private Map<String,String> paramMap;

    /**
     * header参数(只提取自己需要的参数)
     */
    private Map<String,String> headerMap;

}
