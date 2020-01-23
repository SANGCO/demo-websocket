package com.example.demowebsocket.listener;

import com.example.demowebsocket.domain.CustomMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CustomMessageListener {

    @RabbitListener(queues = "test-queue")
    public void receiveMessage(final CustomMessage customMessage) {
        System.out.println(customMessage);
    }
}
