package com.nsk.cloud.microservicesimpleconsumermovie.feign;

import feign.Contract;
import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author nsk
 * 2018/7/6 8:15
 * 添加该配置类后，在定义FeignClient时，只能使用feign自带的注解
 */
@Configuration
public class FeignConfiguration {

    // 将契约改为feign原生的默认契约
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","password1");
    }

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
