package com.nsk.cloud.microservicesimpleconsumermovie.user;

import com.nsk.cloud.microservicesimpleconsumermovie.feign.FeignClientFallback;
import com.nsk.cloud.microservicesimpleconsumermovie.feign.FeignConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author nsk
 * 2018/7/6 8:12
 * 只能在Controller层使用
 */
@FeignClient(name = "microservice-provider-user",
        configuration = FeignConfiguration.class,fallback = FeignClientFallback.class)
public interface UserDefinedFeignClient {
    @RequestLine("GET /user-api/user/{id}")
    public User findByIdWithDefinedFeign(@Param("id") Long id);
}
