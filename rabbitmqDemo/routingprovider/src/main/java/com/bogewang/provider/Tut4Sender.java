/**
 * Copyright (C), 2015-2020, bogewang
 * FileName: Tut4Sender
 * Author:   foren236598164@aliyun.com
 * Date:     2020/5/13 13:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bogewang.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
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
public class Tut4Sender {
    private Logger logger = LoggerFactory.getLogger(Tut4Sender.class);
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private DirectExchange direct;
    private int index;
    private int count;
    private final String[] keys = {"orange", "black", "green"};

    /**
     * 分三次发给不同的key;
     */
    public void send(){
        StringBuilder builder = new StringBuilder("Hello to ");
        if (++this.index == 3) {
            this.index = 0;
        }
        String key = keys[this.index];
        builder.append(key).append(' ');
        builder.append(Integer.toString(++this.count));
        String message = builder.toString();
        template.convertAndSend(direct.getName(), key, message);
        logger.info(" [x] Sent '" + message + "'");

    }

}
