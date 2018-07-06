package com.nsk.cloud.microservicesimpleconsumermovie.user;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author nsk
 * 2018/7/6 8:15
 * 添加该配置类后，在定义FeignClient时，只能使用feign自带的注解
 */
@Configuration
public class FeignConfiguration {
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }
}
