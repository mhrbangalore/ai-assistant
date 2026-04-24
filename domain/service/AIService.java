package com.mohan.ai_assistant.domain.service;

import com.mohan.ai_assistant.domain.model.PromptType;

public interface AIService {
    String execute(PromptType type, String input);
}
