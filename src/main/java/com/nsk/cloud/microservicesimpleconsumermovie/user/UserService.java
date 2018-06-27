package com.nsk.cloud.microservicesimpleconsumermovie.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author nsk
 * 2018/6/26 22:52
 */
@Service
@ConfigurationProperties(prefix = "user-service")
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUserById(Long id) {
        return restTemplate.getForObject(this.url + id, User.class);
    }
}
