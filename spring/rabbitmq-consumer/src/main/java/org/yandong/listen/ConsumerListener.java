package org.yandong.listen;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * MessageListener接口用于spring容器接收到消息后处理消息
 * 延迟队列消费者
 */
@Component
public class ConsumerListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        // 将message对象转换成json
        String str = new String(message.getBody());
        System.out.println("str" + str);
    }
}
