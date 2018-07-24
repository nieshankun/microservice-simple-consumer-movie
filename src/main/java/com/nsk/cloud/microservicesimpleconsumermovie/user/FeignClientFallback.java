package com.nsk.cloud.microservicesimpleconsumermovie.user;

import org.springframework.stereotype.Component;

/**
 * @author nsk
 * 2018/7/19 8:09
 */
@Component
public class FeignClientFallback implements UserFeignClient,UserDefinedFeignClient {
    @Override
    public User findById(Long id){
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户1");
        return user;
    }

    public User findByIdWithDefinedFeign(Long id){
        User user = new User();
        user.setId(-2L);
        user.setName("默认用户2");
        return user;
    }
}
