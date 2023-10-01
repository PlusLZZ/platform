package com.liuzz.platform.auth.filter;

import com.liuzz.platform.auth.config.core.AuthManage;
import com.liuzz.platform.common.constants.AuthConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class AuthFilter extends OncePerRequestFilter {

    private final PathMatcher matcher;

    private final AuthManage authManage;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        authManage.handle(request,response);
    }

    /**
     * 需要排除的请求
     * 只有登录接口需要进行过滤
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String uri = request.getRequestURI();
        return AuthConstant.FILTER_URLS.stream().noneMatch(url->matcher.match(url,uri));
    }
}
