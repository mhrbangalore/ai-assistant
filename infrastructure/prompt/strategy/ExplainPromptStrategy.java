package com.mohan.ai_assistant.infrastructure.prompt.strategy;

import com.mohan.ai_assistant.domain.model.PromptType;
import org.springframework.stereotype.Component;

@Component
public class ExplainPromptStrategy implements PromptStrategy {

    @Override
    public PromptType supports() {
        return PromptType.EXPLAIN;
    }

    @Override
    public String build(String input) {
        return """
        You are a senior backend engineer.

        Explain clearly:
        %s

        Include:
        - Simple explanation
        - Real-world analogy
        - Use cases
        """.formatted(input);
    }
}
