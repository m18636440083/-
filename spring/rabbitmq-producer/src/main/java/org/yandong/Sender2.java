package org.yandong;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring整合RabbitMQ
 * 消息生产者
 * 测试超长度死信队列
 */
public class Sender2 {
    public static void main(String[] args) {
        // 创建spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-rabbitmq-producer-dlx.xml");
        // 从容器中获取对象
        RabbitTemplate template = context.getBean(RabbitTemplate.class);
        // 发送消息
        template.convertAndSend("dlx_max", "超长度死信队列".getBytes());
        template.convertAndSend("dlx_max", "超长度死信队列".getBytes());
        template.convertAndSend("dlx_max", "超长度死信队列".getBytes());
        template.convertAndSend("dlx_max", "超长度死信队列".getBytes());
        System.out.println("消息已发送成功");
        context.close();

    }
}
