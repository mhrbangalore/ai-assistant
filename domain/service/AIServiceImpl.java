package com.mohan.ai_assistant.domain.service;

import com.mohan.ai_assistant.domain.model.PromptType;
import com.mohan.ai_assistant.infrastructure.llm.OllamaClient;

import com.mohan.ai_assistant.infrastructure.prompt.PromptFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIServiceImpl implements AIService {

    private final PromptFactory promptFactory;
    private final OllamaClient ollamaClient;

    @Override
    public String execute(PromptType type, String input) {

        String prompt = promptFactory.build(type, input);

        return ollamaClient.generate(prompt);
    }
}
