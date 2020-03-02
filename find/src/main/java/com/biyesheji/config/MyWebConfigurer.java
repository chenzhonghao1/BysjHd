package com.biyesheji.config;

import com.biyesheji.interceptor.LoginInterceptor;
import com.biyesheji.interceptor.TokenInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {

    private TokenInterceptor tokenInterceptor;

    //构造方法
    public MyWebConfigurer(TokenInterceptor tokenInterceptor){
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer){
        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3)));
        configurer.setDefaultTimeout(30000);
    }

//    @Bean
//    public LoginInterceptor getLoginIntercepter() {
//        return new LoginInterceptor();
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        List<String> excludePath = new ArrayList<>();
        //排除拦截，除了注册登录(此时还没token)，其他都拦截
        excludePath.add("/api/register");  //注册
        excludePath.add("/api/mobile");  //注册时验证手机号码是否已经注册
        excludePath.add("/api/username");  //注册时验证名字是否已经注册
        excludePath.add("/api/login");     //登录
        excludePath.add("/photo/**");     //登录
        excludePath.add("/error");
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = "G:\\photo\\";
        // 上传路径映射 会使spring boot的自动配置失效
        registry.addResourceHandler("/photo/**").addResourceLocations("file:" + path);

        WebMvcConfigurer.super.addResourceHandlers(registry);

    }


}
