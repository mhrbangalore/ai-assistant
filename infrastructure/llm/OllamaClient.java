package com.mohan.ai_assistant.infrastructure.llm;

import com.mohan.ai_assistant.exception.AIException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class OllamaClient {

    private final OllamaConfig config;
    private final RestTemplate restTemplate = new RestTemplate();
    private final WebClient webClient = WebClient.create("http://localhost:11434");

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

    public Flux<String> stream(String prompt) {

        Map<String, Object> request = Map.of(
                "model", config.getModel(),
                "prompt", prompt,
                "stream", true
        );

        return webClient.post()
                .uri("/api/generate")
                .bodyValue(request)
                .retrieve()
                .bodyToFlux(Map.class)
                .map(chunk -> chunk.get("response").toString());
    }

}
