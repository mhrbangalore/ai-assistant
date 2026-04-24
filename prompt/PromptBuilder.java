package com.mohan.ai_assistant.prompt;

import org.springframework.stereotype.Component;

@Component
public class PromptBuilder {

    public String buildExplainPrompt(String input) {
        return """
                You are a senior software engineer.
                
                Explain the following concept in simple terms:
                %s
                
                Provide:
                - Short explanation
                - Real-world example
                - When to use it
                """.formatted(input);
    }

    public String buildStructuredPrompt(String input) {
        return """
                You are an expert backend engineer.
                
                Answer strictly in this format:
                
                Explanation:
                ...
                
                Example:
                ...
                
                Use Cases:
                ...
                
                Topic:
                %s
                """.formatted(input);
    }

    public String codeReviewPrompt(String input) {
        return """
                You are a senior backend engineer who is tasked to review code for better quality and efficiency.
                
                Review and point out mistakes and suggest the improvements.
                
                This is the code: %s
                """.formatted(input);
    }
}
