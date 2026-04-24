package com.mohan.ai_assistant.service;

import com.mohan.ai_assistant.client.OllamaClient;
import com.mohan.ai_assistant.prompt.PromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIService {

    private final OllamaClient client;
    private final PromptBuilder promptBuilder;

    public String explainConcept(String input) {

        String prompt = promptBuilder.buildExplainPrompt(input);

        return client.generate(prompt);
    }

    public String structuredConcept(String input) {

        String prompt = promptBuilder.buildStructuredPrompt(input);

        return client.generate(prompt);
    }

    public String codeReviewPrompt(String input) {

        String prompt = promptBuilder.codeReviewPrompt(input);

        return client.generate(prompt);
    }
}
