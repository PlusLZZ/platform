package com.liuzz.platform.auth.config.core;

import com.liuzz.platform.auth.context.AuthContext;
import com.liuzz.platform.auth.handler.AuthHandler;
import com.liuzz.platform.common.domain.ErrorCode;
import com.liuzz.platform.common.domain.GlobalCode;
import com.liuzz.platform.common.domain.R;
import com.liuzz.platform.utils.web.ServletUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * 权限管理器,核心过滤器的组织逻辑
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class AuthManage {

    private final List<AuthHandler> handlerList;

    public void handle(HttpServletRequest request, HttpServletResponse response){
        try {
            AuthContext.init();
            AuthContext.handle(request);
            log.info("上下文数据:{}",AuthContext.get());
            Optional<AuthHandler> first = handlerList.stream().filter(item -> item.support(request)).findFirst();
            if (first.isPresent()){
                first.get().handle(request,response);
            }else {
                ServletUtils.writeJSON(response, R.error(GlobalCode.BAD_REQUEST));
            }
        }finally {
            AuthContext.clear();
        }
    }

}
