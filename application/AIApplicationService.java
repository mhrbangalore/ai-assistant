package com.mohan.ai_assistant.application;

import com.mohan.ai_assistant.domain.model.PromptType;
import com.mohan.ai_assistant.domain.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIApplicationService {

    private final AIService aiService;

    public String process(PromptType type, String input) {
        return aiService.execute(type, input);
    }
}
