package com.bitc.reactasyncserver.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        addMapping() : 지정한 패턴에 맞는 페이지에 대해서 접근 권한 확인
//        allowedOrigins(url) : 접근 허용할 외부 url
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:3000");;
        registry.addMapping("/login/**")  // login 밑에서만 localhost:3000 에서 날라오는것 허용
                .allowedOrigins("http://localhost:3000");
    }
}
