package com.liuzz.platform.auth.handler.clientcredentials;

import com.liuzz.platform.auth.handler.AuthHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class ClientCredentialsHandler implements AuthHandler {
    @Override
    public boolean support(HttpServletRequest request) {
        return false;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) {

    }
}
