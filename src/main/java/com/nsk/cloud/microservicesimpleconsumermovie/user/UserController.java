package com.nsk.cloud.microservicesimpleconsumermovie.user;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nsk
 * 2018/6/26 22:04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private UserDefinedFeignClient userDefinedFeignClient;

    @HystrixCommand(fallbackMethod = "findByIdFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "8000")
    })
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    public User findByIdFallback(Long id){
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

    @GetMapping("/instance")
    public List<ServiceInstance> showInfo() {
        return this.discoveryClient.getInstances("microservice-provider-user");
    }

    @GetMapping("/log-instance")
    public void logUserInstance() {
        userService.logUserInstance();
    }

    @GetMapping("/feign/{id}")
    public User getUserByIdWithFeign(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/defined/feign/{id}")
    public User getUserByIdWithDefinedFeign(@PathVariable Long id){
        return this.userDefinedFeignClient.findByIdWithDefinedFeign(id);
    }


}
