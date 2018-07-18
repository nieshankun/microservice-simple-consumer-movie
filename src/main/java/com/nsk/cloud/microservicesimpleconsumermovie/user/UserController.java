package com.nsk.cloud.microservicesimpleconsumermovie.user;

import com.netflix.discovery.converters.Auto;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
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

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
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
