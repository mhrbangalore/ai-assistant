package com.mohan.ai_assistant.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatMessage {
    private String role; // USER / AI
    private String content;
}
