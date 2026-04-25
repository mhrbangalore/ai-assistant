package com.mohan.ai_assistant.service;

import com.mohan.ai_assistant.domain.model.PromptType;
import reactor.core.publisher.Flux;

public interface AIService {
    String execute(PromptType type, String input);
    Flux<String> stream(PromptType type, String input, String sessionId);
}
