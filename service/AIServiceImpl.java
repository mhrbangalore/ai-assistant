package com.mohan.ai_assistant.service;

import com.mohan.ai_assistant.domain.model.ChatMessage;
import com.mohan.ai_assistant.domain.model.PromptType;
import com.mohan.ai_assistant.infrastructure.llm.OllamaClient;

import com.mohan.ai_assistant.infrastructure.memory.InMemoryChatStore;
import com.mohan.ai_assistant.infrastructure.prompt.PromptFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AIServiceImpl implements AIService {

    private final PromptFactory promptFactory;
    private final OllamaClient ollamaClient;
    private final InMemoryChatStore chatStore;

    @Override
    public String execute(PromptType type, String input) {

        String prompt = promptFactory.build(type, input);

        return ollamaClient.generate(prompt);
    }

    @Override
    public Flux<String> stream(PromptType type, String input, String sessionId) {
        List<ChatMessage> history = chatStore.get(sessionId);

        history.add(new ChatMessage("USER", input));

        String prompt = promptFactory.buildWithHistory(type, history);
        return ollamaClient.stream(prompt)
                .doOnNext(token -> {
                    // accumulate response (optional)
                })
                .doOnComplete(() -> {
                    chatStore.add(sessionId, new ChatMessage("AI", "FULL_RESPONSE"));
                });

    }

    private List<ChatMessage> trim(List<ChatMessage> messages) {
        int max = 10;
        if (messages.size() <= max) return messages;

        return messages.subList(messages.size() - max, messages.size());
    }






















}
