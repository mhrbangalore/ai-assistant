package com.mohan.ai_assistant.infrastructure.prompt.strategy;

import com.mohan.ai_assistant.domain.model.PromptType;

public interface PromptStrategy {
    PromptType supports();
    String build(String input);
}
