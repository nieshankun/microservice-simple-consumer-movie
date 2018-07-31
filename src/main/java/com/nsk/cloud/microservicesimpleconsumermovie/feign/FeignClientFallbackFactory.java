package com.nsk.cloud.microservicesimpleconsumermovie.feign;

import com.nsk.cloud.microservicesimpleconsumermovie.user.User;
import com.nsk.cloud.microservicesimpleconsumermovie.user.UserFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author nsk
 * 2018/7/29 22:03
 */
@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger logger = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                FeignClientFallbackFactory.logger.info("fallback;reason was:", cause);
                User user = new User();
                user.setId(-1L);
                user.setUsername("默认用户3");
                return null;
            }
        };
    }
}
