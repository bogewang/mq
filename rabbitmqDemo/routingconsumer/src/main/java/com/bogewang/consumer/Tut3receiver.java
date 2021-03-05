/**
 * Copyright (C), 2015-2020, bogewang
 * FileName: Tut3receiver
 * Author:   foren236598164@aliyun.com
 * Date:     2020/5/13 9:20
 * Description: 消息接收方
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bogewang.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 〈一句话功能简述〉
 * 〈消息接收方〉
 *
 * @author foren236598164@aliyun.com
 * @create 2020/5/13
 * @since 1.0.0
 */
@Component
public class Tut3receiver {
    private Logger logger = LoggerFactory.getLogger(Tut3receiver.class);

    @RabbitListener(queues = RabbitMqExchangeConfig.QUEUE3)
    public void receiver3(String in) throws InterruptedException{
        receive(in, 3);
    }

    @RabbitListener(queues = RabbitMqExchangeConfig.QUEUE4)
    public void receiver4(String in) throws InterruptedException{
        receive(in, 4);
    }

    public void receive(String in , int receiver) throws  InterruptedException{
        StopWatch watch = new StopWatch();
        // watch.start();
        logger.info("instance " + receiver + " [x] Received '" + in +"'");
        // dowork(in);
        // watch.stop();
        // logger.info("instance " +receiver + " [x] Done in " +watch.getTotalTimeSeconds() + "s");
    }

    private void dowork(String in) throws InterruptedException {
        Thread.sleep(1000);
    }
}
