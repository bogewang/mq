package com.bogewang;

import com.bogewang.sender.Tut5Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TopicsApplicationTests {
    @Autowired
    private Tut5Sender tutSender;

    @Test
    void contextLoads() {
        tutSender.send();
    }
}
