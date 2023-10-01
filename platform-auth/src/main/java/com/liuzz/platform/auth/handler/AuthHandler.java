package com.liuzz.platform.auth.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthHandler {
    boolean support(HttpServletRequest request);

    void handle(HttpServletRequest request, HttpServletResponse response);

}
