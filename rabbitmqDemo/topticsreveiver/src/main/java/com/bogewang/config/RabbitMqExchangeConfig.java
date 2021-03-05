/**
 * Copyright (C), 2015-2020, bogewang
 * FileName: RabbitMqExchangeConfig
 * Author:   foren236598164@aliyun.com
 * Date:     2020/5/13 9:20
 * Description: 消息配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bogewang.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉
 * 〈消息配置类〉
 *
 * @author foren236598164@aliyun.com
 * @create 2020/5/13
 * @since 1.0.0
 */
@Configuration
public class RabbitMqExchangeConfig {

    public static final String QUEUE5 = "queue5";
    public static final String QUEUE6 = "queue6";

    /**
     * 主题交换器;
     * @return
     */
    @Bean
    public TopicExchange topic(){
        return new TopicExchange("tut.topic");
    }

    private static class TopicConfig{
        @Bean
        public Queue autoDeleteQueue5(){
            return new Queue(QUEUE5);
        }

        @Bean
        public Queue autoDeleteQueue6(){
            return new Queue(QUEUE6);
        }

        //              *.orange.* ->queue5
        // tut.topic -> *.*.rabbit->queue5
        //              lazy.#    ->queue6

        //星号匹配一个单词，哈希号匹配多个单词
        @Bean
        public Binding binding3a(TopicExchange topic, Queue autoDeleteQueue5){
            return BindingBuilder.bind(autoDeleteQueue5).to(topic).with("*.orange.*");
        }

        @Bean
        public Binding binding3b(TopicExchange topic, Queue autoDeleteQueue5){
            return BindingBuilder.bind(autoDeleteQueue5).to(topic).with("*.*.rabbit");
        }
        @Bean
        public Binding binding4a(TopicExchange topic, Queue autoDeleteQueue6){
            return BindingBuilder.bind(autoDeleteQueue6).to(topic).with("lazy.#");
        }


    }

}
