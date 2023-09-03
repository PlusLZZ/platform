package com.liuzz.platform.framework.web.filter;

import com.liuzz.platform.common.constants.HeaderKey;
import com.liuzz.platform.utils.id.IdUtils;
import com.liuzz.platform.utils.string.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TraceFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String traceId = request.getHeader(HeaderKey.TRACE_ID);
        if (StringUtils.isBlank(traceId)){
            traceId = IdUtils.nextId();
        }
        // 设置响应 traceId
        response.addHeader(HeaderKey.TRACE_ID, traceId);
        // 继续过滤
        filterChain.doFilter(request, response);
    }

}
