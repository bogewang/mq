/**
 * Copyright (C), 2015-2020, bogewang
 * FileName: HelloSender
 * Author:   foren236598164@aliyun.com
 * Date:     2020/5/12 19:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bogewang.sender;

import com.bogewang.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.amqp.core.Queue;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author foren236598164@aliyun.com
 * @create 2020/5/12
 * @since 1.0.0
 */
@Component
public class HelloSender {
    @Autowired
    private Queue dateQueue;
    @Autowired
    private Queue objQueue;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "now data ".concat(new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(new Date()));
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend(dateQueue.getName(), context);
    }


    public void sendObj(User user){
        System.out.println("Sender : " + user);
        rabbitTemplate.convertAndSend(objQueue.getName(), user);
    }

}
