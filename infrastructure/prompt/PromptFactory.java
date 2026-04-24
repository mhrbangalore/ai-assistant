package com.mohan.ai_assistant.infrastructure.prompt;

import com.mohan.ai_assistant.domain.model.PromptType;
import com.mohan.ai_assistant.infrastructure.prompt.strategy.PromptStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PromptFactory {

    private final Map<PromptType, PromptStrategy> strategyMap;

    public PromptFactory(List<PromptStrategy> strategies) {
        this.strategyMap = strategies.stream()
                .collect(Collectors.toMap(
                        PromptStrategy::supports,
                        Function.identity()
                ));
    }

    public String build(PromptType type, String input) {
        return strategyMap.get(type).build(input);
    }
}
