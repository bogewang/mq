/**
 * Copyright (C), 2015-2020, bogewang
 * FileName: Tut3Sender
 * Author:   foren236598164@aliyun.com
 * Date:     2020/5/13 12:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bogewang.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author foren236598164@aliyun.com
 * @create 2020/5/13
 * @since 1.0.0
 */
@Service
public class Tut3Sender {

    private Logger logger = LoggerFactory.getLogger(Tut3Sender.class);
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private FanoutExchange fanout;
    int dots = 0;
    int count = 0;
    public void send(){
        StringBuilder builder = new StringBuilder("hello");
        if (dots++ == 3){
            dots = 1;
        }

        for (int i=0; i<dots; i++){
            builder.append(".");
        }

        builder.append(++count);
        String msg = builder.toString();
        template.convertAndSend(fanout.getName(), "", msg);
        logger.info(" [x] Send '" + msg +"'" );
    }

}
