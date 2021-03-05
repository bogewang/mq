package com.bogewang;

import com.bogewang.sender.Tut3Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PsproviderApplicationTests {
    @Autowired
    private Tut3Sender sender;

    @Test
    void contextLoads() {
        for ( int i=0; i<10; i++){
            sender.send();
        }
    }

}
