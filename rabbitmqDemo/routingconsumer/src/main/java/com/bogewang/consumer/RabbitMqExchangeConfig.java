/**
 * Copyright (C), 2015-2020, bogewang
 * FileName: RabbitMqExchangeConfig
 * Author:   foren236598164@aliyun.com
 * Date:     2020/5/13 13:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bogewang.consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author foren236598164@aliyun.com
 * @create 2020/5/13
 * @since 1.0.0
 */
@Configuration
public class RabbitMqExchangeConfig {

    public static final String QUEUE3 = "queue3";
    public static final String QUEUE4 = "queue4";

    @Bean
    public DirectExchange fanout(){
        return new DirectExchange("tut.direct");
    }

    private static class DirectConfig{

        @Bean
        public Queue autoDeleteQueue3(){
            return new Queue(QUEUE3);
        }
        @Bean
        public Queue autoDeleteQueue4(){
            return new Queue(QUEUE4);
        }

        //                orange  ->queue3
        //  tut.direct -> black   ->queue3,queue4
        //                green   ->queue4
        //
        @Bean
        public Binding binding1a(DirectExchange direct, Queue autoDeleteQueue3){
            return BindingBuilder.bind(autoDeleteQueue3).to(direct).with("orange");
        }
        @Bean
        public Binding binding1b(DirectExchange direct, Queue autoDeleteQueue3){
            return BindingBuilder.bind(autoDeleteQueue3).to(direct).with("black");
        }
        @Bean
        public Binding binding2a(DirectExchange direct, Queue autoDeleteQueue4){
            return BindingBuilder.bind(autoDeleteQueue4).to(direct).with("green");
        }
        @Bean
        public Binding binding2b(DirectExchange direct, Queue autoDeleteQueue4){
            return BindingBuilder.bind(autoDeleteQueue4).to(direct).with("black");
        }

    }

}
