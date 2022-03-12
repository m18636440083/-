package org.yandong;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * spring整合RabbitMQ
 * 消息生产者
 * 测试超时死信队列
 */
public class Sender {
    public static void main(String[] args) {
        // 创建spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-rabbitmq-producer-dlx.xml");
        // 从容器中获取对象
        RabbitTemplate template = context.getBean(RabbitTemplate.class);
        // 发送消息
        template.convertAndSend("dlx_ttl", "超时死信队列".getBytes());
        System.out.println("消息已发送成功");
        context.close();

    }
}
