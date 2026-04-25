package com.mohan.ai_assistant.infrastructure.memory;

import com.mohan.ai_assistant.domain.model.ChatMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryChatStore {

    private final Map<String, List<ChatMessage>> store = new ConcurrentHashMap<>();

    public List<ChatMessage> get(String sessionId) {
        return store.computeIfAbsent(sessionId, k -> new ArrayList<>());
    }

    public void add(String sessionId, ChatMessage message) {
        get(sessionId).add(message);
    }
}
