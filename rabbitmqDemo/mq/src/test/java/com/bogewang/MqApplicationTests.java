package com.bogewang;

import com.bogewang.model.User;
import com.bogewang.sender.HelloSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MqApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello(){
        helloSender.send();
    }

    @Test
    public void object(){
        User user = new User();
        user.setName("bogewang");
        user.setAge(10);
        helloSender.sendObj(user);
    }

}
