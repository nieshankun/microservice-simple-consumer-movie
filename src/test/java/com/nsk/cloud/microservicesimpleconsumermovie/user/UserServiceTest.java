package com.nsk.cloud.microservicesimpleconsumermovie.user;

import com.nsk.cloud.microservicesimpleconsumermovie.MicroserviceSimpleConsumerMovieApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author nsk
 * 2018/6/26 22:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MicroserviceSimpleConsumerMovieApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserById() throws Exception {
        Long id = 1L;
        User user = userService.getUserById(id);
        assertEquals(user.getUsername(),"account1");
    }

}