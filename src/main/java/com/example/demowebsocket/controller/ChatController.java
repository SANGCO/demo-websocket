package com.example.demowebsocket.controller;

import com.example.demowebsocket.domain.Message;
import com.example.demowebsocket.domain.OutputMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @GetMapping("/test")
    public String testSendTo() throws Exception {
        return "test";
    }

//    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
//    public OutputMessage send(final Message message) throws Exception {
//        final String time = new SimpleDateFormat("HH:mm").format(new Date());
//        return new OutputMessage(message.getFrom(), message.getText(), time);
//    }

    @MessageMapping("/chat")
    @SendToUser("/queue/reply")
    public OutputMessage processMessageFromClient(final Message message, Principal principal) throws Exception {
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

}
