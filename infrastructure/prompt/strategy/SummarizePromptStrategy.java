package com.mohan.ai_assistant.infrastructure.prompt.strategy;

import com.mohan.ai_assistant.domain.model.PromptType;
import org.springframework.stereotype.Component;

@Component
public class SummarizePromptStrategy implements PromptStrategy {

    @Override
    public PromptType supports() {
        return PromptType.SUMMARIZE;
    }

    @Override
    public String build(String input) {
        return """
        Summarize the following:

        %s

        Keep it:
        - concise
        - structured
        """.formatted(input);
    }
}
