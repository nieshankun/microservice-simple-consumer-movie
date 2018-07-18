package com.nsk.cloud.microservicesimpleconsumermovie.user;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author nsk
 * 2018/7/3 20:30
 * 只能对Controller层进行使用
 */
@FeignClient(name = "microservice-provider-user",configuration = FeignConfiguration.class)
public interface UserFeignClient {
//    @RequestMapping(value = "/user-api/user/{id}", method = RequestMethod.GET)
    @RequestLine("GET /user-api/user/{id}")
    public User findById(@Param("id") Long id);
}
