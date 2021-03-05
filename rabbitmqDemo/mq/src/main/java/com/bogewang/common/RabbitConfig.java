/**
 * Copyright (C), 2015-2020, bogewang
 * FileName: RabbitConfig
 * Author:   foren236598164@aliyun.com
 * Date:     2020/5/12 19:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bogewang.common;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author foren236598164@aliyun.com
 * @create 2020/5/12
 * @since 1.0.0
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue dateQueue(){
        return new Queue("date") ;
    }

    @Bean
    public Queue objQueue(){
        return new Queue("object");
    }


}
