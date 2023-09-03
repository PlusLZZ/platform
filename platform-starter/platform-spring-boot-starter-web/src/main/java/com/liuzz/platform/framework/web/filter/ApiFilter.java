package com.liuzz.platform.framework.web.filter;

import com.liuzz.platform.common.constants.HeaderKey;
import com.liuzz.platform.utils.date.SystemClock;
import com.liuzz.platform.utils.id.IdUtils;
import com.liuzz.platform.utils.string.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class ApiFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 设置请求时间
        request.setAttribute(HeaderKey.REQUEST_TIME, SystemClock.now());
        // 继续过滤
        filterChain.doFilter(request, response);
    }

}
