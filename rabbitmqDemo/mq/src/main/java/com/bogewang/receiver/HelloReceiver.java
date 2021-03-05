/**
 * Copyright (C), 2015-2020, bogewang
 * FileName: HelloReceiver
 * Author:   foren236598164@aliyun.com
 * Date:     2020/5/12 19:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bogewang.receiver;

import com.bogewang.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author foren236598164@aliyun.com
 * @create 2020/5/12
 * @since 1.0.0
 */
@Component
public class HelloReceiver implements Serializable {


    @RabbitListener(queues = "date") //队列名字;
    public void processDate(String date){
        System.out.println("Receiver =====================: " + date);
    }

    @RabbitListener(queues = "object")
    public void processObj(User user){
        System.out.println("Receiver ==============: " + user);
    }
}
