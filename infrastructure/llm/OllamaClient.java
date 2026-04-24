package com.mohan.ai_assistant.infrastructure.llm;

import com.mohan.ai_assistant.exception.AIException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class OllamaClient {

    private final OllamaConfig config;
    private final RestTemplate restTemplate = new RestTemplate();

    public String generate(String prompt) {

        String url = config.getBaseUrl() + "/api/generate";

        Map<String, Object> request = Map.of(
                "model", config.getModel(),
                "prompt", prompt,
                "stream", false
        );

        try {
            Map response = restTemplate.postForObject(url, request, Map.class);
            return response.get("response").toString();
        } catch (Exception e) {
            throw new AIException("Failed to call Ollama", e);
        }
    }
}
