package com.bogewang.rocketmq.servier;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
@Component
public class RocketMQServer {

    /**
     * 消费者组名;
     */
    @Value("${apache.rocketmq.consumer.PushConsumer}")
    private String consumerGroup;
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;
    @PostConstruct
    public void defaultMQPushConsumer(){
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
        // 指定nameSrv地址,多个地址 ; 分隔开;
        consumer.setNamesrvAddr(namesrvAddr);

        try{
            consumer.subscribe("TopicTest", "push");
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.registerMessageListener((MessageListenerConcurrently)(list, content) -> {
                try {
                    for (MessageExt messageext: list){
                        System.out.println("messageExt: " + messageext);
                        String messageBody = new String(messageext.getBody(), RemotingHelper.DEFAULT_CHARSET);
                        System.out.println("消费响应: msgID : " + messageext.getMsgId() + ", msgBody : "+ messageBody);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER; //稍后重试;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });
            consumer.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
