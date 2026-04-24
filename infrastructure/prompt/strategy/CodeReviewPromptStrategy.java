package com.mohan.ai_assistant.infrastructure.prompt.strategy;

import com.mohan.ai_assistant.domain.model.PromptType;
import org.springframework.stereotype.Component;

@Component
public class CodeReviewPromptStrategy implements PromptStrategy {

    @Override
    public PromptType supports() {
        return PromptType.CODE_REVIEW;
    }

    @Override
    public String build(String input) {
        return """
        You are a senior software architect.

        Perform a code review:

        %s

        Provide:
        - Issues
        - Improvements
        - Best practices
        """.formatted(input);
    }
}
