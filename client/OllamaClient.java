package com.mohan.ai_assistant.client;

import com.mohan.ai_assistant.config.OllamaConfig;
import com.mohan.ai_assistant.dto.OllamaRequest;
import com.mohan.ai_assistant.dto.OllamaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class OllamaClient {

    private final OllamaConfig config;
    private final RestTemplate restTemplate = new RestTemplate();

    public String generate(String prompt) {

        String url = config.getBaseUrl() + "/api/generate";

        OllamaRequest request = new OllamaRequest();
        request.setModel(config.getModel());
        request.setPrompt(prompt);
        request.setStream(false);

        ResponseEntity<OllamaResponse> response =
                restTemplate.postForEntity(url, request, OllamaResponse.class);

        return response.getBody().getResponse();
    }
}
