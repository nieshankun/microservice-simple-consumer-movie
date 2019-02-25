package com.nsk.cloud.microservicesimpleconsumermovie.user;

import com.nsk.cloud.microservicesimpleconsumermovie.feign.FeignClientFallbackFactory;
import com.nsk.cloud.microservicesimpleconsumermovie.feign.FeignConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author nsk
 * 2018/7/3 20:30
 * 只能对Controller层进行使用
 */
/*@FeignClient(name = "microservice-provider-user",
        configuration = FeignConfiguration.class,fallback = FeignClientFallback.class)*/
@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class,
            fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {
    // RequestLine是Feign自带的注解
//    @RequestMapping(value = "/user-api/user/{id}", method = RequestMethod.GET)
    @RequestLine("GET /user-api/user/{id}")
    public User findById(@Param("id") Long id);
}
