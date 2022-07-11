package com.openaudio.oa.common.config;

import com.openaudio.oa.handler.PageableHandlerInterceptor;
import com.openaudio.oa.handler.WebSecurityHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web mvc配置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 登录限流处理
     * @return
     */
    @Bean
    public WebSecurityHandler getWebSecurityHandler(){
        return new WebSecurityHandler();
    }

    /**
     * 跨域资源共享登记
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry){
        // 允许跨域访问资源定义： /** 所有资源
        registry.addMapping("/**")
                //允许跨域请求的源列表
                .allowedOrigins("*")
                // 允许发送Cookie
                .allowCredentials(true)
                /*
                * 代替allowCredentials支持通配符模式声明来源
                * 浏览器是否应将凭据（例如 cookie 以及跨域请求）发送到带注释的端点。
                * 配置的值在预检请求的 Access-Control-Allow-Credentials 响应标头上设置。
                * */
                .allowedOriginPatterns("*")
                //*就是默认所有的方法模式
                .allowedMethods("*");
                // 允许 GET", POST, PUT, DELETE 方法
                //.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }

    /**
     * 帮助配置拦截器映射表
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //添加提供的HandlerInterceptor--添加拦截器
        //mybatisPlus 分页工具拦截器
        registry.addInterceptor(new PageableHandlerInterceptor());
        //redis限流拦截器
        registry.addInterceptor(getWebSecurityHandler());
    }

}
