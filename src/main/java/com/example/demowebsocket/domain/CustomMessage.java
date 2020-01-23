package com.example.demowebsocket.domain;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomMessage {

    private String text;

    private int priority;

    private boolean secret;

}
