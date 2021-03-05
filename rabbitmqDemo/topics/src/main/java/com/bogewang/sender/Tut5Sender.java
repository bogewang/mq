/**
 * Copyright (C), 2015-2020, bogewang
 * FileName: TutSender
 * Author:   foren236598164@aliyun.com
 * Date:     2020/5/13 9:28
 * Description: 消息发送者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bogewang.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉
 * 〈消息发送者〉
 *
 * @author foren236598164@aliyun.com
 * @create 2020/5/13
 * @since 1.0.0
 */
@Service
public class Tut5Sender {
    private Logger logger = LoggerFactory.getLogger(Tut5Sender.class);
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private TopicExchange topic;
    private int index;
    private int count;
    private final String[] keys = {"quick.orange.rabbit",
            "lazy.orange.elephant", "quick.orange.fox",
            "lazy.brown.fox", "lazy.pink.rabbit", "quick.brown.fox"};
    public void send(){
        StringBuilder builder = new StringBuilder("Hello to ");
        if (++this.index == keys.length) {
            this.index = 0;
        }
        String key = keys[this.index];
        builder.append(key).append(' ');
        builder.append(Integer.toString(++this.count));
        String message = builder.toString();
        template.convertAndSend(topic.getName(), key, message);
        logger.info(" [x] Sent '" + message + "'");
    }

}
