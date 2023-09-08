package com.liuzz.platform.auth.config.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

//@Configuration
public class MatcherConfig {

    @Bean
    public PathMatcher pthMatcher(){
        return new AntPathMatcher();
    }

}
