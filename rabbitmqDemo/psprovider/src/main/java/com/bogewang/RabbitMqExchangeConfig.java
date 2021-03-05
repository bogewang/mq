/**
 * Copyright (C), 2015-2020, bogewang
 * FileName: RabbitMqExchangeConfig
 * Author:   foren236598164@aliyun.com
 * Date:     2020/5/13 12:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bogewang;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
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
    public static final String QUEUE1 = "queue1";
    public static final String QUEUE2 = "queue2";

    @Bean
    public FanoutExchange fanout(){
        return new FanoutExchange("tut.fanout");
    }

    private static class FanoutConfig{
        @Bean
        public Queue autoDeleteQueue1(){
            return new Queue(QUEUE1);
        }
        @Bean
        public Queue autoDeleteQueue2(){
            return new Queue(QUEUE2);
        }
        //队列和交换机绑定
        //这种关系可以读作：这个队列对这个交换器里的消息感兴趣。
        //虽然 Queue类型有多个实例，但spring会自动更加名字匹配，bean名字匹配参数名字
        @Bean
        public Binding building1(FanoutExchange fanout, Queue autoDeleteQueue1){
            return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
        }
        @Bean
        public Binding building2(FanoutExchange fanout, Queue autoDeleteQueue2){
            return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
        }

    }

}
