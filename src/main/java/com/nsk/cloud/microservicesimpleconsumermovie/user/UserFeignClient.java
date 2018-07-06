package com.nsk.cloud.microservicesimpleconsumermovie.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author nsk
 * 2018/7/3 20:30
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
    @RequestMapping(value = "/user-api/user/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}
