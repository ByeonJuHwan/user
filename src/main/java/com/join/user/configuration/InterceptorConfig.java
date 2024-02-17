package com.join.user.configuration;

import com.join.user.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/", "/logout", "/login","/api/join","/swagger-custom-ui.html","/swagger-ui/v1/index.html","/swagger-ui",
                        "/css/**", "/*.ico", "/error"
                );
    }
}
